package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import em.Tabla;
import em.Id.SISTRANS_Id;
import em.Many.ManytoMany;
import jdk.nashorn.internal.ir.annotations.Reference;

/**
 * Clase que representa un Ingrediente.
 */
@Tabla
public class Ingrediente {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	@SISTRANS_Id(AutoIncrement=true)
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Nombre del ingrediente.
	 */
	@JsonProperty(value = "nombre")
	private String nombre;

	/**
	 * Descripción del ingrediente.
	 */
	@JsonProperty(value = "descripcion")
	private String descripcion;

	/**
	 * Traducción de descripción del ingrediente.
	 */
	@JsonProperty(value = "traduccion")
	private String traduccion;
	
	@Reference
	@ManytoMany
	private List<Producto> productos;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	public Ingrediente() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método constructor de la clase ingrediente. <b>post: </b> Crea el
	 * ingrediente con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del ingrediente.
	 * @param nombre
	 *            - Nombre del ingrediente. nombre != null
	 * @param descripcion
	 *            - Descripción del ingrediente.
	 * @param traduccion
	 *            - Traducción de descripción del ingrediente.
	 */
	public Ingrediente(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre,
			@JsonProperty(value = "descripcion") String descripcion,
			@JsonProperty(value = "traduccion") String traduccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.traduccion = traduccion;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo id
	 * 
	 * @return id del ingrediente
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del ingrediente ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del ingrediente
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre
	 * 
	 * @return nombre del ingrediente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre <b>post: </b> El nombre del ingrediente
	 * ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param nombre
	 *            - Nombre del ingrediente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo descripción.
	 * 
	 * @return descripción del ingrediente.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método setter del atributo descripción <b>post: </b> La descripción del
	 * ingrediente ha sido cambiada por el valor que entra como parámetro.
	 * 
	 * @param descripcion
	 *            - Descripción del ingrediente.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método getter del atributo traducción.
	 * 
	 * @return traducción de la descripción del ingrediente.
	 */
	public String getTraduccion() {
		return traduccion;
	}

	/**
	 * Método setter del atributo traducción <b>post: </b> La traducción de la
	 * descripción del ingrediente ha sido cambiada por el valor que entra como
	 * parámetro.
	 * 
	 * @param traduccion
	 *            - Traducción de la descripción del ingrediente.
	 */
	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
