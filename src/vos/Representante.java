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
	 * Método constructor de la clase representante. <b>post: </b> Crea el
	 * representante con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del representante.
	 * @param nombre
	 *            - Nombre del representante. nombre != null
	 * @param telefono
	 *            - Teléfono del representante.
	 * @param correo
	 *            - Correo electrónico del representante.
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
	 * Método getter del atributo id.
	 * 
	 * @return id del representante.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del representante ha
	 * sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del representante.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre.
	 * 
	 * @return id del representante.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre <b>post: </b> El nombre del
	 * representante ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param nombre
	 *            - Nombre del representante.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo teléfono.
	 * 
	 * @return teléfono del representante.
	 */
	public Integer getTelefono() {
		return telefono;
	}

	/**
	 * Método setter del atributo teléfono <b>post: </b> El teléfono del
	 * representante ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param teléfono
	 *            - Teléfono del representante.
	 */
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método getter del atributo correo.
	 * 
	 * @return id del representante.
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Método setter del atributo correo <b>post: </b> El correo del
	 * representante ha sido cambiado con el valor que entra como parámetro.
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
