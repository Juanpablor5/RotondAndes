package em;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import em.Columna.SISTRANS_Columna;
import em.Foreing.ForeignKey;
import em.Id.SISTRANS_Id;
import em.Tipos.Tipo;

public class TablaMannager extends Connector {
	private final static SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/YYYY");
	private final static SimpleDateFormat formatoTime = new SimpleDateFormat("dd/MM/YYYY");
	private final String TABLA;
	
	public TablaMannager(Class<?> clase,Connection conn) {
		setConn(conn);
		TABLA = clase.getSimpleName();
	}

	private Field[] ids(Class<?> clase) {
		List<Field> ids = new LinkedList<>();
		for (Field f : clase.getDeclaredFields())
			if (f.isAnnotationPresent(SISTRANS_Id.class))
				ids.add(f);
		Field[] idsA = new Field[ids.size()];
		for (int i = 0; i < ids.size(); i++)
			idsA[i] = ids.get(i);
		return idsA;
	}
	
	public <T> void create(Class<T> clase,T objeto) throws SQLException {
		List<String> tabla = new LinkedList<>();
		List<String> values = new LinkedList<>();

		for (Field field : clase.getDeclaredFields()) {
			if (field.isAnnotationPresent(SISTRANS_Columna.class) || (field.isAnnotationPresent(Id.SISTRANS_Id.class)
					&& !field.getAnnotation(SISTRANS_Id.class).AutoIncrement())) {
				field.setAccessible(true);
				tabla.add(field.getName());
				try {
					values.add(format(field, field.get(objeto)));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		executeModification("INSERT INTO " + TABLA + " ( " + Arista.listFormatString(tabla, ",") + ") VALUES ("
				+ Arista.listFormatString(values, ",") + ")");
	}

	public <T> List<T> getAll(Class<T> clase) throws SQLException {
		List<T> data = new ArrayList<>();
		String sql = "SELECT * FROM " + TABLA;
		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			data.add(extract(clase,rs));
		}
		return data;
	}
	
	public  Object get(Class<?> class1,Object object) throws SQLException {
		String sql = "SELECT * FROM " + TABLA;
		sql += SearchSentence(class1,object);
		
		ResultSet rs = executeModification(sql);

		if (rs.next()) {
			return extract(class1,rs);
		}
		return null;
	}

	public <T> T update(Class<T> clase,T registro) throws SQLException {
		try {
			List<String> seters = new LinkedList<>();

			for (Field field : clase.getDeclaredFields()) {
				if (field.isAnnotationPresent(SISTRANS_Columna.class)) {
					field.setAccessible(true);
					seters.add(field.getName() + " = " + format(field, field.get(registro)));
				} else if (field.isAnnotationPresent(ForeignKey.class)) {

				}
			}
			executeModification(
					"UPDATE " + TABLA + " SET " + Arista.listFormatString(seters, ",") + SearchSentence(clase,registro));
			return registro;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}

	}

	public <T> T remove(Class<T> clase,T references) throws SQLException {
		String sql = "DELETE FROM " + TABLA;
		sql += SearchSentence(clase,references);

		executeModification(sql);
		return references;
	}

	private <T> T extract(Class<T> clase,ResultSet rs) throws SQLException {
		try {
			T t = clase.newInstance();
			for (Field field : clase.getDeclaredFields()) {
				if (field.isAnnotationPresent(Id.SISTRANS_Id.class)
						|| field.isAnnotationPresent(SISTRANS_Columna.class)) {
					field.setAccessible(true);
					field.set(t, getRs(rs, field));
				}
			}
			return t;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new SQLException("no hay constructor vacio en la clase " + TABLA);
		}
	}

	private Object getRs(ResultSet rs, Field field) throws SQLException {
		try {
			if (field.getType().equals(Integer.class))
				return rs.getInt(field.getName());
			if (field.getType().equals(Long.class))
				return rs.getLong(field.getName());
			if (field.getType().equals(Double.class))
				return rs.getDouble(field.getName());
			if (field.getType().equals(Date.class))
				if (field.getAnnotation(DateAnotation.class).completa())
					return formatoTime.parse(rs.getString(field.getName()));
				else return rs.getDate(field.getName());
			if(field.getType().equals(String.class))
				return rs.getString(field.getName());
			return rs.getObject(field.getName());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new SQLException("error formato de fechas");
		}
	}

	private String SearchSentence(Class<?> class1, Object object) throws SQLException {
		try {
			List<String> search = new LinkedList<>();

			for (Field field : ids(class1)) {
				field.setAccessible(true);
				search.add(field.getName() + " = " + format(field, field.get(object)));
			}
			return " WHERE" + Arista.listFormatString(search, " AND ");
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}

	private String format(Field field, Object value) throws SQLException {
		if (Tipos.is(field.getType(), Tipo.INTEGER) || Tipos.is(field.getType(), Tipo.NUMBER))
			return value.toString();
		if (Tipos.is(field.getType(), Tipo.VARCHAR2))
			return "'" + value.toString() + "";
		if (Tipos.is(field.getType(), Tipo.DATE)) {
			if (field.getAnnotation(DateAnotation.class).completa())
				return "'" + formatoTime.format((Date) value) + "'";
			else
				return "'" + formatoDate.format((Date) value) + "'";
		}
		throw new SQLException("el id no es un tipo permitido");
	}

}
