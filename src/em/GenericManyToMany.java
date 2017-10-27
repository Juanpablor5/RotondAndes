package em;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import em.Id.SISTRANS_Id;
import em.Many.ManytoMany;

public class GenericManyToMany<T, S> extends Connector {
	private final static SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/YYYY");
	private final static SimpleDateFormat formatoTime = new SimpleDateFormat("dd/MM/YYYY");
	private final Class<T> claseT;
	private final Class<S> claseS;
	private final List<String> ids;
	protected final String TABLA;
	protected final Extractor<T> extrT;
	protected final Extractor<S> extrS;

	public GenericManyToMany(Class<T> claseT, Class<S> claseS) throws SQLException {
		this.claseS = claseS;
		this.claseT = claseT;
		this.TABLA = claseT.getSimpleName() + "_" + claseS.getSimpleName();
		ids = new LinkedList<>();
		Field fieldT = fieldOfClass(claseT, claseS);
		for (Field f : claseS.getDeclaredFields())
			if (f.isAnnotationPresent(SISTRANS_Id.class))
				ids.add(fieldT.getName() + "_" + f.getName());
		Field fieldS = fieldOfClass(claseT, claseS);
		for (Field f : claseT.getDeclaredFields())
			if (f.isAnnotationPresent(SISTRANS_Id.class))
				ids.add(fieldS.getName() + "_" + f.getName());
		this.extrS = new Extractor<>(claseS);
		this.extrT = new Extractor<>(claseT);
	}

	private Field fieldOfClass(Class<?> claseA, Class<?> claseB) throws SQLException {
		for (Field field : claseA.getDeclaredFields())
			if (field.isAnnotationPresent(ManytoMany.class) && field.getType().equals(List.class)
					&& (((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]).equals(claseB))
				return field;
		throw new SQLException("no existe un foreing key de la clase: " + claseB);
	}
}
