package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Menu.
 */
public class Menu {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id del men�.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * La cantidad de men�s que se ofrece.
	 */
	@JsonProperty(value = "cantidad")
	private Integer cantidad;

	/**
	 * El costo de producci�n del men�.
	 */
	@JsonProperty(value = "costoProduccion")
	private Double costoProduccion;

	/**
	 * El valor al p�blico del men�.
	 */
	@JsonProperty(value = "valorAlPublico")
	private Double valorAlPublico;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase men�. <b>post: </b> Crea el men� con los
	 * valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id del men�.
	 * @param cantidad
	 *            - Nombre del men�. nombre != null
	 * @param costoProduccion
	 *            - Descripci�n del men�.
	 * @param valorAlPublico
	 *            - Traducci�n de descripci�n del men�.
	 */
	public Menu(@JsonProperty(value = "id") Long id, @JsonProperty(value = "cantidad") Integer cantidad,
			@JsonProperty(value = "costoProduccion") Double costoProduccion,
			@JsonProperty(value = "valorAlPublico") Double valorAlPublico) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.costoProduccion = costoProduccion;
		this.valorAlPublico = valorAlPublico;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id
	 * 
	 * @return id del men�
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del men� ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del men�
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo cantidad.
	 * 
	 * @return Cantidad de men�s que se ofrece.
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * M�todo setter del atributo cantidad <b>post: </b> El cantidad de men�s ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param cantidad
	 *            - Cantidad de men�s disponibles.
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * M�todo getter del atributo costoProduccion
	 * 
	 * @return Costo de producci�n del men�.
	 */
	public Double getCostoProduccion() {
		return costoProduccion;
	}

	/**
	 * M�todo setter del atributo costoProduccion <b>post: </b> El costo de
	 * producci�n del men� ha sido cambiado con el valor que entra como
	 * par�metro.
	 * 
	 * @param costoProduccion
	 *            - El costo de producci�n del men�
	 */
	public void setCostoProduccion(Double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	/**
	 * M�todo getter del atributo valorAlPublico
	 * 
	 * @return Valor al p�blico del men�.
	 */
	public Double getValorAlPublico() {
		return valorAlPublico;
	}

	/**
	 * M�todo setter del atributo valorAlPublico <b>post: </b> El valor al
	 * publico del men� ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param valorAlPublico
	 *            - Valor al publico del men�
	 */
	public void setValorAlPublico(Double valorAlPublico) {
		this.valorAlPublico = valorAlPublico;
	}

}
