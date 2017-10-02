package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Categor�a.
 */
public class Categoria {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id de la categor�a.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Nombre de la categor�a.
	 */
	@JsonProperty(value = "nombre")
	private String nombre;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase categor�a. <b>post: </b> Crea la categor�a
	 * con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id de la categor�a.
	 * @param nombre
	 *            - Nombre de la categor�a. nombre != null
	 */
	public Categoria(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id
	 * 
	 * @return id de la categor�a
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id de la categor�a ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id de la categor�a
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo nombre
	 * 
	 * @return nombre de la categor�a
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo setter del atributo nombre <b>post: </b> El nombre de la categor�a
	 * ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param nombre
	 *            - Nombre de la categor�a.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
