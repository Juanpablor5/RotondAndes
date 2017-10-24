package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import em.Columna;
import em.Id;
import em.Id.SISTRANS_Id;
import em.Tabla;
import em.Columna.SISTRANS_Columna;

/**
 * Clase que representa un Categoría.
 */
@Tabla
public class Categoria {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id de la categoría.
	 */
	@SISTRANS_Id
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Nombre de la categoría.
	 */
	@SISTRANS_Columna
	@JsonProperty(value = "nombre")
	private String nombre;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase categoría. <b>post: </b> Crea la categoría
	 * con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id de la categoría.
	 * @param nombre
	 *            - Nombre de la categoría. nombre != null
	 */
	public Categoria(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo id
	 * 
	 * @return id de la categoría
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id de la categoría ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id de la categoría
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre
	 * 
	 * @return nombre de la categoría
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre <b>post: </b> El nombre de la categoría
	 * ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param nombre
	 *            - Nombre de la categoría.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
