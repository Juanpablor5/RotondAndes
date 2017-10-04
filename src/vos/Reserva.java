package vos;


import org.codehaus.jackson.annotate.JsonProperty;


/**
 * Clase que representa un Producto.
 */
public class Reserva {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id de la reserva.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Fecha de la reserva.
	 */
	@JsonProperty(value = "fechahora")
	private String fechahora;

	/**
	 * Duración de la reserva.
	 */
	@JsonProperty(value = "duracion")
	private Integer duracion;

	/**
	 * Numero de comensales de la reserva.
	 */
	@JsonProperty(value = "comensales")
	private Integer comensales;

	/**
	 * Nombre del comensal que hace la reserva.
	 */
	@JsonProperty(value = "nombreReservante")
	private String nombreReservante;

	/**
	 * Numero telefónico del comensal que hace la reserva.
	 */
	@JsonProperty(value = "telefonoReservante")
	private Long telefonoReservante;
	
	/**
	 * id de la zona a la que pertenece
	 */
	@JsonProperty(value = "zona_id")
	private Long zona_id;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase Reserva. <b>post: </b> Crea el producto
	 * con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id de la reserva.
	 * @param fechahora
	 *            - Fecha y la hora de la reserva.
	 * @param comensales
	 *            - Comensales de descripción de la reserva.
	 * @param nombreReservante
	 *            - Nombre del comensal que hace la reserva.
	 * @param telefonoReservante
	 *            - Numero telefónico del comensal que hace la reserva.
	 * @param zona_id 
	 */
	public Reserva(@JsonProperty(value = "id") Long id, @JsonProperty(value = "fechahora") String fechahora,
			@JsonProperty(value = "duracion") Integer duracion, @JsonProperty(value = "comensales") Integer comensales,
			@JsonProperty(value = "nombreReservante") String nombreReservante,
			@JsonProperty(value = "telefonoReservante") Long telefonoReservante,	
			@JsonProperty(value = "zona_id") Long zona_id) {
		super();
		this.id = id;
		this.fechahora = fechahora;
		this.duracion = duracion;
		this.comensales = comensales;
		this.nombreReservante = nombreReservante;
		this.telefonoReservante = telefonoReservante;
		this.zona_id=zona_id;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo id.
	 * 
	 * @return id de la reserva.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id de la reserva ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id de la reserva.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo fecha.
	 * 
	 * @return fecha y hora de la reserva.
	 */
	public String getFechahora() {
		return fechahora;
	}

	/**
	 * Método setter del atributo fecha hora <b>post: </b> La fecha y la hora de
	 * la reserva ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param fechahora
	 *            - Fecha y hora de la reserva.
	 */
	public void setFechahora(String fechahora) {
		this.fechahora = fechahora;
	}

	/**
	 * Método getter del atributo comensales.
	 * 
	 * @return comensales de la reserva.
	 */
	public Integer getComensales() {
		return comensales;
	}

	/**
	 * Método setter del atributo comensales <b>post: </b> Los comensales de la
	 * reserva ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param comensales
	 *            - Comensales de la reserva.
	 */
	public void setComensales(Integer comensales) {
		this.comensales = comensales;
	}

	/**
	 * Método getter del atributo duración.
	 * 
	 * @return duración de la reserva.
	 */
	public Integer getDuracion() {
		return duracion;
	}

	/**
	 * Método setter del atributo duración <b>post: </b> La duración de la
	 * reserva ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param duración
	 *            - Duración de la reserva.
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	/**
	 * Método getter del atributo nombreReservante.
	 * 
	 * @return Nombre del comensal que hace la reserva.
	 */
	public String getNombreReservante() {
		return nombreReservante;
	}

	/**
	 * Método setter del atributo nombreReservante <b>post: </b> El nombre
	 * comensal que hace la reserva ha sido cambiado con el valor que entra como
	 * parámetro.
	 * 
	 * @param nombreReservante
	 *            - Nombre del comensal que hace la reserva.
	 */
	public void setNombreReservante(String nombreReservante) {
		this.nombreReservante = nombreReservante;
	}

	/**
	 * Método getter del atributo telefonoReservante.
	 * 
	 * @return Numero telefónico del comensal que hace la reserva.
	 */
	public Long getTelefonoReservante() {
		return telefonoReservante;
	}

	/**
	 * Método setter del atributo telefonoReservante <b>post: </b> El numero
	 * telefónico del comensal que hace la reserva ha sido cambiado con el valor
	 * que entra como parámetro.
	 * 
	 * @param telefonoReservante
	 *            - Numero telefónico del comensal que hace la reserva.
	 */
	public void setTelefonoReservante(Long telefonoReservante) {
		this.telefonoReservante = telefonoReservante;
	}

	/**
	 * dar el id de la zona a la quepertenece
	 * @return el id de la zona a la que pertenece
	 */
	public Long getZona_id() {
		return zona_id;
	}

	/**
	 * cambiar el id de la zona a la que pertenece
	 * @param zona_id el id de la nueva zona
	 */
	public void setZona_id(Long zona_id) {
		this.zona_id = zona_id;
	}

	
}
