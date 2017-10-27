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
	 * M�todo constructor de la clase producto. <b>post: </b> Crea el producto con
	 * los valores que entran como par�metro.
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
	 * tiempoPreparacion del producto ha sido cambiado con el valor que entra como
	 * par�metro.
	 * 
	 * @param tiempoPreparacion
	 *            - Tiempo de preparaci�n del producto.
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
