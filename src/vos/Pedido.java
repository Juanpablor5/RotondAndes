package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un pedido.
 */
public class Pedido {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id del pedido.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Fecha de ingreso del pedido.
	 */
	@JsonProperty(value = "fecha")
	private Date fecha;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase pedido. <b>post: </b> Crea el pedido con
	 * los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del pedido.
	 * @param fecha
	 *            - Fecha de ingreso del pedido. nombre != null
	 */
	public Pedido(@JsonProperty(value = "id") Long id, @JsonProperty(value = "fecha") Date fecha) {
		super();
		this.id = id;
		this.fecha = fecha;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo id
	 * 
	 * @return id del pedido
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del pedido ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del pedido
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo fecha
	 * 
	 * @return fecha de ingreso del pedido
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Método setter del atributo fecha <b>post: </b> La fecha del pedido ha
	 * sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param fecha
	 *            - Fecha del pedido
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
