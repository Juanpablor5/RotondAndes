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
	 * Tel�fono del representante.
	 */
	@JsonProperty(value = "telefono")
	private Integer telefono;

	/**
	 * Correo electr�nico del representante.
	 */
	@JsonProperty(value = "correo")
	private String correo;
	
	@JsonProperty(value = "restauranteId")
	private Long restauranteId;

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
