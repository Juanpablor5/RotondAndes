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
	 * Descripci�n del producto.
	 */
	@JsonProperty(value = "descripcion")
	private String descripcion;

	/**
	 * Traducci�n de descripci�n del producto.
	 */
	@JsonProperty(value = "traduccion")
	private String traduccion;

	/**
	 * El tiempo en minutos de la preparaci�n.
	 */
	@JsonProperty(value = "tiempoPreparacion")
	private Integer tiempoPreparacion;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase producto. <b>post: </b> Crea el producto
	 * con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id del producto.
	 * @param nombre
	 *            - Nombre del producto. nombre != null
	 * @param descripcion
	 *            - Descripci�n del producto.
	 * @param traduccion
	 *            - Traducci�n de descripci�n del producto.
	 * @param tiempoPreparacion
	 *            - El tiempo en minutos de la preparaci�n.
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
	 * M�todo getter del atributo id.
	 * 
	 * @return id del producto.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del producto ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del producto.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo nombre.
	 * 
	 * @return id del producto.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo setter del atributo nombre <b>post: </b> El nombre del producto ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param nombre
	 *            - Nombre del producto.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M�todo getter del atributo descripci�n.
	 * 
	 * @return descripci�n del producto.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * M�todo setter del atributo descripci�n <b>post: </b> La descripci�n del
	 * producto ha sido cambiada por el valor que entra como par�metro.
	 * 
	 * @param descripcion
	 *            - Descripci�n del producto.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * M�todo getter del atributo traducci�n.
	 * 
	 * @return traducci�n de la descripci�n del producto.
	 */
	public String getTraduccion() {
		return traduccion;
	}

	/**
	 * M�todo setter del atributo traducci�n <b>post: </b> La traducci�n de la
	 * descripci�n del producto ha sido cambiada por el valor que entra como
	 * par�metro.
	 * 
	 * @param traduccion
	 *            - Traducci�n de la descripci�n del producto.
	 */
	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	/**
	 * M�todo getter del atributo tiempoPreparaion.
	 * 
	 * @return tiempo de preparaci�n del producto.
	 */
	public Integer getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	/**
	 * M�todo setter del atributo tiempoPreparacion <b>post: </b> El
	 * tiempoPreparacion del producto ha sido cambiado con el valor que entra
	 * como par�metro.
	 * 
	 * @param tiempoPreparacion
	 *            - Tiempo de preparaci�n del producto.
	 */
	public void setTiempoPreparacion(Integer tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}
}
