package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import em.Checks;
import em.Reference;
import em.Check.SISTRANS_Check;
import em.Columna.SISTRANS_Columna;
import em.Foreing.ForeignKey;
import em.Id.SISTRANS_Id;
import em.Many.ManytoMany;

/**
 * Clase que representa un Producto.
 */
public class Producto {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------
	@SISTRANS_Id(AutoIncrement = true)
	@JsonProperty(value = "id")
	private Long id;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "nombre")
	private String nombre;

	@SISTRANS_Columna(maxSize = 1000)
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "descripcion")
	private String descripcion;

	@SISTRANS_Columna(maxSize = 1200)
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "traduccion")
	private String traduccion;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.HIGHER, of = "0")
	@JsonProperty(value = "tiempoPreparacion")
	private Integer tiempoPreparacion;

	@Reference
	@ForeignKey
	private Categoria categoria;
	
	@Reference
	@ManytoMany(mapped="productos")
	private List<Ingrediente> ingredientes;
	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase producto. <b>post: </b> Crea el producto con
	 * los valores que entran como parámetro.
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
	 * @param categoriaID
	 */
	public Producto(Categoria categoria, @JsonProperty(value = "id") Long id,
			@JsonProperty(value = "nombre") String nombre, @JsonProperty(value = "descripcion") String descripcion,
			@JsonProperty(value = "traduccion") String traduccion,
			@JsonProperty(value = "tiempoPreparacion") Integer tiempoPreparacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.traduccion = traduccion;
		this.tiempoPreparacion = tiempoPreparacion;
		this.categoria = categoria;
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
	 * tiempoPreparacion del producto ha sido cambiado con el valor que entra como
	 * parámetro.
	 * 
	 * @param tiempoPreparacion
	 *            - Tiempo de preparación del producto.
	 */
	public void setTiempoPreparacion(Integer tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
}
