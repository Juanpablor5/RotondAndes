package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import em.Checks;
import em.Check.SISTRANS_Check;
import em.Columna.SISTRANS_Columna;
import em.Id.SISTRANS_Id;

/**
 * Clase que representa un tipo de comida.
 */
public class TipoComida {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	@SISTRANS_Id
	@JsonProperty(value = "id")
	private Long id;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "nombre")
	private String nombre;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	public TipoComida() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Método constructor de la clase tipo de comida. <b>post: </b> Crea el tipo
	 * de comida con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del tipo de comida.
	 * @param nombre
	 *            - Nombre del tipo de comida. nombre != null
	 */
	public TipoComida(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo id.
	 * 
	 * @return id del tipo de comida.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del tipo de comida ha
	 * sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del tipo de comida.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre.
	 * 
	 * @return id del tipo de comida.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre <b>post: </b> El nombre del tipo de
	 * comida ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param nombre
	 *            - Nombre del tipo de comida.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
