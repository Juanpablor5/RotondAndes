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
	 * Id del menú.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * La cantidad de menús que se ofrece.
	 */
	@JsonProperty(value = "cantidad")
	private Integer cantidad;

	/**
	 * El costo de producción del menú.
	 */
	@JsonProperty(value = "costoProduccion")
	private Double costoProduccion;

	/**
	 * El valor al público del menú.
	 */
	@JsonProperty(value = "valorAlPublico")
	private Double valorAlPublico;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase menú. <b>post: </b> Crea el menú con los
	 * valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del menú.
	 * @param cantidad
	 *            - Nombre del menú. nombre != null
	 * @param costoProduccion
	 *            - Descripción del menú.
	 * @param valorAlPublico
	 *            - Traducción de descripción del menú.
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
	 * Método getter del atributo id
	 * 
	 * @return id del menú
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del menú ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del menú
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo cantidad.
	 * 
	 * @return Cantidad de menús que se ofrece.
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Método setter del atributo cantidad <b>post: </b> El cantidad de menús ha
	 * sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param cantidad
	 *            - Cantidad de menús disponibles.
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Método getter del atributo costoProduccion
	 * 
	 * @return Costo de producción del menú.
	 */
	public Double getCostoProduccion() {
		return costoProduccion;
	}

	/**
	 * Método setter del atributo costoProduccion <b>post: </b> El costo de
	 * producción del menú ha sido cambiado con el valor que entra como
	 * parámetro.
	 * 
	 * @param costoProduccion
	 *            - El costo de producción del menú
	 */
	public void setCostoProduccion(Double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	/**
	 * Método getter del atributo valorAlPublico
	 * 
	 * @return Valor al público del menú.
	 */
	public Double getValorAlPublico() {
		return valorAlPublico;
	}

	/**
	 * Método setter del atributo valorAlPublico <b>post: </b> El valor al
	 * publico del menú ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param valorAlPublico
	 *            - Valor al publico del menú
	 */
	public void setValorAlPublico(Double valorAlPublico) {
		this.valorAlPublico = valorAlPublico;
	}

}
