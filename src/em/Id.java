package em;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import em.Tipos.Tipo;

public interface Id {
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface SISTRANS_Id {
		boolean AutoIncrement() default false;

		int maxSize() default 100;
	}

	public static String CREATE(Field field) throws GenericException {
		SISTRANS_Id id = field.getAnnotation(SISTRANS_Id.class);
		return field.getName() + " " + type(field,id) 
				+ (Tipos.is(field.getType(), Tipo.INTEGER) && (id.AutoIncrement()) ? " GENERATED BY DEFAULT ON NULL AS IDENTITY" : " NOT NULL") + ",\n";
	}

	static String type(Field field,SISTRANS_Id id) throws GenericException {
		Type clase = field.getType();
		if (Tipos.is(clase, Tipo.INTEGER))
			return Tipo.INTEGER.name();
		if (Tipos.is(clase, Tipo.NUMBER))
			return Tipo.NUMBER.name();
		if (clase.equals(String.class))
			return "VARCHAR2(" + id.maxSize() + ")";
		if (Tipos.is(clase, Tipo.DATE))
			if (field.isAnnotationPresent(DateAnotation.class))
				if (field.getAnnotation(DateAnotation.class).completa())
					return Tipo.TIMESTAMP.name();
				else
					return Tipo.DATE.name();
			else
				throw new GenericException("el tipo fecha no esta especificado");
		throw new GenericException("el tipo no es un atributo atomico");
	}
}
