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
	 * Descripci�n del ingrediente.
	 */
	@JsonProperty(value = "descripcion")
	private String descripcion;

	/**
	 * Traducci�n de descripci�n del ingrediente.
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
	 * M�todo constructor de la clase ingrediente. <b>post: </b> Crea el
	 * ingrediente con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id del ingrediente.
	 * @param nombre
	 *            - Nombre del ingrediente. nombre != null
	 * @param descripcion
	 *            - Descripci�n del ingrediente.
	 * @param traduccion
	 *            - Traducci�n de descripci�n del ingrediente.
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
	 * M�todo getter del atributo id
	 * 
	 * @return id del ingrediente
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del ingrediente ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del ingrediente
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo nombre
	 * 
	 * @return nombre del ingrediente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo setter del atributo nombre <b>post: </b> El nombre del ingrediente
	 * ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param nombre
	 *            - Nombre del ingrediente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M�todo getter del atributo descripci�n.
	 * 
	 * @return descripci�n del ingrediente.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * M�todo setter del atributo descripci�n <b>post: </b> La descripci�n del
	 * ingrediente ha sido cambiada por el valor que entra como par�metro.
	 * 
	 * @param descripcion
	 *            - Descripci�n del ingrediente.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * M�todo getter del atributo traducci�n.
	 * 
	 * @return traducci�n de la descripci�n del ingrediente.
	 */
	public String getTraduccion() {
		return traduccion;
	}

	/**
	 * M�todo setter del atributo traducci�n <b>post: </b> La traducci�n de la
	 * descripci�n del ingrediente ha sido cambiada por el valor que entra como
	 * par�metro.
	 * 
	 * @param traduccion
	 *            - Traducci�n de la descripci�n del ingrediente.
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
