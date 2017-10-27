package vos;

import org.codehaus.jackson.annotate.JsonProperty;
import em.Id.SISTRANS_Id;
import em.Checks;
import em.Tabla;
import em.Check.SISTRANS_Check;
import em.Columna.SISTRANS_Columna;

/**
 * Clase que representa una Zona.
 */
@Tabla
public class Zona {

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

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	public Zona() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * M�todo constructor de la clase producto. <b>post: </b> Crea el producto con
	 * los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id de la zona.
	 * @param nombre
	 *            - Nombre de la zona. nombre != null
	 */
	public Zona(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id.
	 * 
	 * @return id de la zona.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id de la zona ha sido cambiado
	 * con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id de la zona.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo nombre.
	 * 
	 * @return id de la zona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo setter del atributo nombre <b>post: </b> El nombre de la zona ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param nombre
	 *            - Nombre de la zona.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
