package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Producto.
 */
public class Producto {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id del producto.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Nombre del producto.
	 */
	@JsonProperty(value = "nombre")
	private String nombre;

	/**
	 * Descripción del producto.
	 */
	@JsonProperty(value = "descripcion")
	private String descripcion;

	/**
	 * Traducción de descripción del producto.
	 */
	@JsonProperty(value = "traduccion")
	private String traduccion;

	/**
	 * El tiempo en minutos de la preparación.
	 */
	@JsonProperty(value = "tiempoPreparacion")
	private Integer tiempoPreparacion;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase producto. <b>post: </b> Crea el producto
	 * con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del producto.
	 * @param nombre
	 *            - Nombre del producto. nombre != null
	 * @param descripcion
	 *            - Descripción del producto.
	 * @param traduccion
	 *            - Traducción de descripción del producto.
	 * @param tiempoPreparacion
	 *            - El tiempo en minutos de la preparación.
	 */
	public Producto(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre,
			@JsonProperty(value = "descripcion") String descripcion,
			@JsonProperty(value = "traduccion") String traduccion,
			@JsonProperty(value = "tiempoPreparacion") Integer tiempoPreparacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.traduccion = traduccion;
		this.tiempoPreparacion = tiempoPreparacion;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo id.
	 * 
	 * @return id del producto.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del producto ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del producto.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre.
	 * 
	 * @return id del producto.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre <b>post: </b> El nombre del producto ha
	 * sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param nombre
	 *            - Nombre del producto.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo descripción.
	 * 
	 * @return descripción del producto.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método setter del atributo descripción <b>post: </b> La descripción del
	 * producto ha sido cambiada por el valor que entra como parámetro.
	 * 
	 * @param descripcion
	 *            - Descripción del producto.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método getter del atributo traducción.
	 * 
	 * @return traducción de la descripción del producto.
	 */
	public String getTraduccion() {
		return traduccion;
	}

	/**
	 * Método setter del atributo traducción <b>post: </b> La traducción de la
	 * descripción del producto ha sido cambiada por el valor que entra como
	 * parámetro.
	 * 
	 * @param traduccion
	 *            - Traducción de la descripción del producto.
	 */
	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	/**
	 * Método getter del atributo tiempoPreparaion.
	 * 
	 * @return tiempo de preparación del producto.
	 */
	public Integer getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	/**
	 * Método setter del atributo tiempoPreparacion <b>post: </b> El
	 * tiempoPreparacion del producto ha sido cambiado con el valor que entra
	 * como parámetro.
	 * 
	 * @param tiempoPreparacion
	 *            - Tiempo de preparación del producto.
	 */
	public void setTiempoPreparacion(Integer tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}
}
