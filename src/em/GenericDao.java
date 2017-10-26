package em;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import em.Columna.SISTRANS_Columna;
import em.Foreing.ForeignKey;
import em.Id.SISTRANS_Id;
import em.Tipos.Tipo;

public class GenericDao<T> extends Connector {
	private final static SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/YYYY");
	private final static SimpleDateFormat formatoTime = new SimpleDateFormat("dd/MM/YYYY");
	private final String TABLA;
	private final Class<T> clase;
	protected final Field[] ids;

	public GenericDao(Class<T> clase, Connection conn) {
		this.clase = clase;
		setConn(conn);
		TABLA = clase.getSimpleName();
		List<Field> ids = new LinkedList<>();
		for (Field f : clase.getDeclaredFields())
			if (f.isAnnotationPresent(SISTRANS_Id.class))
				ids.add(f);
		this.ids = new Field[ids.size()];
		for (int i = 0; i < ids.size(); i++)
			this.ids[i] = ids.get(i);
	}

	public final void create(T objeto) throws SQLException {
		List<String> tabla = new LinkedList<>();
		List<String> values = new LinkedList<>();

		for (Field field : clase.getDeclaredFields()) {
			if (field.isAnnotationPresent(SISTRANS_Columna.class) || (field.isAnnotationPresent(Id.SISTRANS_Id.class)
					&& !field.getAnnotation(SISTRANS_Id.class).AutoIncrement())) {
				tabla.add(field.getName());
				try {
					values.add(format(field, field.get(objeto)));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			} else if (field.isAnnotationPresent(ForeignKey.class)) {

			}
		}
		executeModification("INSERT INTO " + TABLA + " ( " + Arista.listFormatString(tabla, ",") + ") VALUES ("
				+ Arista.listFormatString(values, ",") + ")");
	}

	public final List<T> getAll() throws SQLException {
		String sql = "SELECT * FROM " + TABLA;
		ResultSet rs = executeModification(sql);

		return new Extractor<T>(clase).extractList(rs);
	}

	public final T get(T registro) throws SQLException {
		String sql = "SELECT * FROM " + TABLA;
		sql += SearchSentence(registro);

		ResultSet rs = executeModification(sql);

		return new Extractor<T>(clase).extract(rs);
	}

	public final T get(Object... ids) throws SQLException {
		String sql = "SELECT * FROM " + TABLA;
		sql += SearchSentence(ids);

		System.out.println("tabla"+TABLA);
		ResultSet rs = executeModification(sql);

		return new Extractor<T>(clase).extract(rs);
	}
	
	public final T getDetail(T registro) throws SQLException {
		String sql = "SELECT * FROM " + TABLA;
		sql += SearchSentence(registro);

		ResultSet rs = executeModification(sql);

		return new Extractor<T>(clase).extractDetail(rs, conn);
	}

	public final T getDetail(Object... ids) throws SQLException {
		String sql = "SELECT * FROM " + TABLA;
		sql += SearchSentence(ids);

		ResultSet rs = executeModification(sql);

		return new Extractor<T>(clase).extractDetail(rs, conn);
	}
	
	public List<T> getWithForeing(Field field, Object object) throws SQLException {
		String sql = "SELECT * FROM " + TABLA;
		sql += SearchSentence(field,object);

		ResultSet rs = executeModification(sql);

		return new Extractor<T>(clase).extractList(rs);
	}

	public final T update(T registro) throws SQLException {
		try {
			List<String> seters = new LinkedList<>();

			for (Field field : clase.getDeclaredFields()) {
				if (field.isAnnotationPresent(SISTRANS_Columna.class)) {
					Method method = clase.getMethod(getMethod(field.getName()));
					seters.add(field.getName() + " = " + format(field, method.invoke(registro)));
				} else if (field.isAnnotationPresent(ForeignKey.class)) {

				}
			}
			executeModification(
					"UPDATE " + TABLA + " SET " + Arista.listFormatString(seters, ",") + SearchSentence(registro));
			return registro;
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
				| InvocationTargetException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}

	}

	public final T remove(Object... ids) throws SQLException {
		T t = get(ids);
		String sql = "DELETE FROM " + TABLA;
		sql += SearchSentence(ids);

		executeModification(sql);
		return t;
	}

	public final T remove(T references) throws SQLException {
		String sql = "DELETE FROM " + TABLA;
		sql += SearchSentence(references);

		executeModification(sql);
		return references;
	}



	private String getMethod(String str) {
		return "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

	
	private String SearchSentence(Object[] objects) throws SQLException {
		Hashtable<Class<?>, Object> hash = new Hashtable<>();
		for (Object object : objects)
			hash.put(object.getClass(), object);
		List<String> search = new LinkedList<>();

		for (Field field : ids)
			search.add(field.getName() + " = " + format(field, hash.get(field.getType())));
		return " WHERE" + Arista.listFormatString(search, " AND ");
	}
	
	private String SearchSentence(Field fieldB, Object objectA) throws SQLException {
		try {
			List<String> search = new LinkedList<>();
			Field[] idsForeings = Id.ids(fieldB.getType());
			for (Field f : idsForeings) {
				Method method = fieldB.getType().getMethod(getMethod(f.getName()));
				search.add(fieldB.getName() + "_" + f.getName() + " = " + method.invoke(objectA));
			}
			return " WHERE" + Arista.listFormatString(search, " AND ");
		} catch (IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException
				| IllegalAccessException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}

	private String SearchSentence(T object) throws SQLException {
		try {
			List<String> search = new LinkedList<>();

			for (Field field : ids) {
				Method method = clase.getMethod(getMethod(field.getName()));
				search.add(field.getName() + " = " + format(field, method.invoke(object)));
			}
			return " WHERE" + Arista.listFormatString(search, " AND ");
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
				| InvocationTargetException e) {
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
