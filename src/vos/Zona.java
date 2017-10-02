package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa una Zona.
 */
public class Zona {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id de la zona.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Nombre de la zona.
	 */
	@JsonProperty(value = "nombre")
	private String nombre;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase producto. <b>post: </b> Crea el producto
	 * con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id de la zona.
	 * @param nombre
	 *            - Nombre de la zona. nombre != null
	 */
	public Zona(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo id.
	 * 
	 * @return id de la zona.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id de la zona ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id de la zona.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre.
	 * 
	 * @return id de la zona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre <b>post: </b> El nombre de la zona ha
	 * sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param nombre
	 *            - Nombre de la zona.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
