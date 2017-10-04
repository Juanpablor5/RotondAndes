package vos;

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
	@JsonProperty(value = "fechahora")
	private String fechahora;
	
	/**
	 * C�dula del cliente que hizo el pedido.
	 */
	@JsonProperty(value = "clienteCedula")
	private Integer clienteCedula;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase pedido. <b>post: </b> Crea el pedido con
	 * los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id del pedido.
	 * @param fechahora
	 *            - Fecha de ingreso del pedido. nombre != null
	 * @param clienteCedula
	 *            - C�dula del cliente que hizo el pedido.
	 */
	public Pedido(@JsonProperty(value = "id") Long id, @JsonProperty(value = "fechahora") String fechahora,
			@JsonProperty(value = "clienteCedula") Integer clienteCedula) {
		super();
		this.id = id;
		this.fechahora = fechahora;
		this.clienteCedula = clienteCedula;
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
	public String getFechahora() {
		return fechahora;
	}

	/**
	 * M�todo setter del atributo fecha <b>post: </b> La fecha del pedido ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param fecha
	 *            - Fecha del pedido
	 */
	public void setFechahora(String fechahora) {
		this.fechahora = fechahora;
	}

	/**
	 * M�todo getter del atributo clienteCedula
	 * 
	 * @return C�dula del cliente que hizo el pedido.
	 */
	public Integer getClienteCedula() {
		return clienteCedula;
	}

	/**
	 * M�todo setter del atributo clienteCedula <b>post: </b> La c�dula del cliente que hizo el pedido ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param clienteCedula
	 *            - C�dula del cliente del pedido
	 */
	public void setClienteCedula(Integer clienteCedula) {
		this.clienteCedula = clienteCedula;
	}
}
