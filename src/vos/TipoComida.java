package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un tipo de comida.
 */
public class TipoComida {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id del tipo de comida.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Nombre del tipo de comida.
	 */
	@JsonProperty(value = "nombre")
	private String nombre;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase tipo de comida. <b>post: </b> Crea el tipo
	 * de comida con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id del tipo de comida.
	 * @param nombre
	 *            - Nombre del tipo de comida. nombre != null
	 */
	public TipoComida(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id.
	 * 
	 * @return id del tipo de comida.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del tipo de comida ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del tipo de comida.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo nombre.
	 * 
	 * @return id del tipo de comida.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo setter del atributo nombre <b>post: </b> El nombre del tipo de
	 * comida ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param nombre
	 *            - Nombre del tipo de comida.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
