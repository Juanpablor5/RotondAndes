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
	 * Anotaciones específicas del pedido.
	 */
	@JsonProperty(value = "anotaciones")
	private String anotaciones;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase subpedido. <b>post: </b> Crea el subpedido
	 * con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del subpedido.
	 * @param anotaciones
	 *            - Anotaciones específicas del subpedido. nombre != null
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
	 * Método getter del atributo id
	 * 
	 * @return id del subpedido
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del subpedido ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del subpedido
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre
	 * 
	 * @return nombre del subpedido
	 */
	public String getNombre() {
		return anotaciones;
	}

	/**
	 * Método setter del atributo nombre <b>post: </b> El nombre del subpedido
	 * ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param nombre
	 *            - Nombre del subpedido.
	 */
	public void setNombre(String anotaciones) {
		this.anotaciones = anotaciones;
	}
}
