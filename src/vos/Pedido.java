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
	 * M�todo constructor de la clase pedido. <b>post: </b> Crea el pedido con
	 * los valores que entran como par�metro.
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
	 * M�todo getter del atributo id
	 * 
	 * @return id del pedido
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del pedido ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del pedido
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo fecha
	 * 
	 * @return fecha de ingreso del pedido
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * M�todo setter del atributo fecha <b>post: </b> La fecha del pedido ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param fecha
	 *            - Fecha del pedido
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
