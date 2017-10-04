package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Representante.
 */
public class Representante {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id del representante.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Nombre del representante.
	 */
	@JsonProperty(value = "nombre")
	private String nombre;

	/**
	 * Teléfono del representante.
	 */
	@JsonProperty(value = "telefono")
	private Integer telefono;

	/**
	 * Correo electrónico del representante.
	 */
	@JsonProperty(value = "correo")
	private String correo;
	
	@JsonProperty(value = "restauranteId")
	private Long restauranteId;

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
			@JsonProperty(value = "restauranteId") Long restauranteId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.restauranteId=restauranteId;
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
	/**
	 * dar el restaurante al que pertenec el representante
	 * @return el restaurante al que pertenece el representante
	 */
	public Long getRestauranteId() {
		return restauranteId;
	}
	/**
	 * cambiar el restaurante e que pertenece el representante
	 * @param restauranteId el nuevo restaurante al que va a pertenecer el representante
	 */
	public void setRestauranteId(Long restauranteId) {
		this.restauranteId = restauranteId;
	}
	
}
