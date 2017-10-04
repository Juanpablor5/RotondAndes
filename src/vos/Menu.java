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
	
	@JsonProperty(value = "productoEntrada")
	private Long productoEntrada;
	
	@JsonProperty(value = "productoFuerte")
	private Long productoFuerte;

	@JsonProperty(value = "productoBebida")
	private Long productoBebida;
	
	@JsonProperty(value = "productoPostre")
	private Long productoPostre;
	
	@JsonProperty(value = "productoAcompanamiento")
	private Long productoAcompanamiento;
	
	@JsonProperty(value = "restauranteID")
	private Long restauranteID;
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
	 * @param productoEntrada 
	 * @param productoFuerte 
	 * @param productoBebida 
	 * @param productoAcompanamiento 
	 * @param restauranteID 
	 * @param procutoPostre 
	 */
	public Menu(@JsonProperty(value = "id") Long id,
			@JsonProperty(value = "cantidad") Integer cantidad,
			@JsonProperty(value = "costoProduccion") Double costoProduccion,
			@JsonProperty(value = "valorAlPublico") Double valorAlPublico,
			@JsonProperty(value = "productoEntrada") Long productoEntrada,
			@JsonProperty(value = "productoFuerte") Long productoFuerte,
			@JsonProperty(value = "productoBebida") Long productoBebida,
			@JsonProperty(value = "productoPostre") Long productoPostre,
			@JsonProperty(value = "productoAcompanamiento") Long productoAcompanamiento,
			@JsonProperty(value = "restauranteID") Long restauranteID) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.costoProduccion = costoProduccion;
		this.valorAlPublico = valorAlPublico;
		this.productoEntrada=productoEntrada;
		this.productoFuerte=productoFuerte;
		this.productoBebida=productoBebida;
		this.productoPostre=productoPostre;
		this.productoAcompanamiento=productoAcompanamiento;
		this.restauranteID=restauranteID;
	}

	// -------------------------------------------------------------
		// Getters & Setters
		// -------------------------------------------------------------

		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(Double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public Double getValorAlPublico() {
		return valorAlPublico;
	}

	public void setValorAlPublico(Double valorAlPublico) {
		this.valorAlPublico = valorAlPublico;
	}

	public Long getProductoEntrada() {
		return productoEntrada;
	}

	public void setProductoEntrada(Long productoEntrada) {
		this.productoEntrada = productoEntrada;
	}

	public Long getProductoFuerte() {
		return productoFuerte;
	}

	public void setProductoFuerte(Long productoFuerte) {
		this.productoFuerte = productoFuerte;
	}

	public Long getProductoBebida() {
		return productoBebida;
	}

	public void setProductoBebida(Long productoBebida) {
		this.productoBebida = productoBebida;
	}

	public Long getProductoPostre() {
		return productoPostre;
	}

	public void setProductoPostre(Long productoPostre) {
		this.productoPostre = productoPostre;
	}

	public Long getProductoAcompanamiento() {
		return productoAcompanamiento;
	}

	public void setProductoAcompanamiento(Long productoAcompanamiento) {
		this.productoAcompanamiento = productoAcompanamiento;
	}

	public Long getRestauranteID() {
		return restauranteID;
	}

	public void setRestauranteID(Long restauranteID) {
		this.restauranteID = restauranteID;
	}

	
}
