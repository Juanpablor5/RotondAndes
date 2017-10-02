package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Subpedido.
 */
public class Subpedido {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id del subpedido.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Anotaciones espec�ficas del pedido.
	 */
	@JsonProperty(value = "anotaciones")
	private String anotaciones;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase subpedido. <b>post: </b> Crea el subpedido
	 * con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id del subpedido.
	 * @param anotaciones
	 *            - Anotaciones espec�ficas del subpedido. nombre != null
	 */
	public Subpedido(@JsonProperty(value = "id") Long id, @JsonProperty(value = "anotaciones") String anotaciones) {
		super();
		this.id = id;
		this.anotaciones = anotaciones;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id
	 * 
	 * @return id del subpedido
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del subpedido ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del subpedido
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo nombre
	 * 
	 * @return nombre del subpedido
	 */
	public String getNombre() {
		return anotaciones;
	}

	/**
	 * M�todo setter del atributo nombre <b>post: </b> El nombre del subpedido
	 * ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param nombre
	 *            - Nombre del subpedido.
	 */
	public void setNombre(String anotaciones) {
		this.anotaciones = anotaciones;
	}
}
