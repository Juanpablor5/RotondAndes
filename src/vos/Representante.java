package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import em.Checks;
import em.Check.SISTRANS_Check;
import em.Columna.SISTRANS_Columna;
import em.Foreing.ForeignKey;
import em.Id.SISTRANS_Id;
import em.Reference;
import em.Tabla;

/**
 * Clase que representa un Representante.
 */
@Tabla
public class Representante {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	@SISTRANS_Id(AutoIncrement=true)
	@JsonProperty(value = "id")
	private Long id;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "nombre")
	private String nombre;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.HIGHER, of = "0")
	@JsonProperty(value = "telefono")
	private Integer telefono;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "correo")
	private String correo;
	
	@Reference
	@ForeignKey(unique=true)
	private Restaurante restaurante;

	/**
	 * M�todo constructor de la clase representante. <b>post: </b> Crea el
	 * representante con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id del representante.
	 * @param nombre
	 *            - Nombre del representante. nombre != null
	 * @param telefono
	 *            - Tel�fono del representante.
	 * @param correo
	 *            - Correo electr�nico del representante.
	 * @param restauranteId 
	 */
	public Representante(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre,
			@JsonProperty(value = "telefono") Integer telefono, @JsonProperty(value = "correo") String correo,
			Restaurante restaurante) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.restaurante=restaurante;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id.
	 * 
	 * @return id del representante.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del representante ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del representante.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo nombre.
	 * 
	 * @return id del representante.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo setter del atributo nombre <b>post: </b> El nombre del
	 * representante ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param nombre
	 *            - Nombre del representante.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M�todo getter del atributo tel�fono.
	 * 
	 * @return tel�fono del representante.
	 */
	public Integer getTelefono() {
		return telefono;
	}

	/**
	 * M�todo setter del atributo tel�fono <b>post: </b> El tel�fono del
	 * representante ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param tel�fono
	 *            - Tel�fono del representante.
	 */
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	/**
	 * M�todo getter del atributo correo.
	 * 
	 * @return id del representante.
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * M�todo setter del atributo correo <b>post: </b> El correo del
	 * representante ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param correo
	 *            - Correo del representante.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
}
