package vos;

import java.util.Date;

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
	@JsonProperty(value = "fecha")
	private Date fechahora;

	/**
	 * Duraci�n de la reserva.
	 */
	@JsonProperty(value = "hora")
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
	 * Numero telef�nico del comensal que hace la reserva.
	 */
	@JsonProperty(value = "telefonoReservante")
	private Integer telefonoReservante;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase Reserva. <b>post: </b> Crea el producto
	 * con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id de la reserva.
	 * @param fechahora
	 *            - Fecha y la hora de la reserva.
	 * @param comensales
	 *            - Comensales de descripci�n de la reserva.
	 * @param nombreReservante
	 *            - Nombre del comensal que hace la reserva.
	 * @param telefonoReservante
	 *            - Numero telef�nico del comensal que hace la reserva.
	 */
	public Reserva(@JsonProperty(value = "id") Long id, @JsonProperty(value = "fecha") Date fechahora,
			@JsonProperty(value = "duracion") Integer duracion, @JsonProperty(value = "comensales") Integer comensales,
			@JsonProperty(value = "nombreReservante") String nombreReservante,
			@JsonProperty(value = "telefonoReservante") Integer telefonoReservante) {
		super();
		this.id = id;
		this.fechahora = fechahora;
		this.duracion = duracion;
		this.comensales = comensales;
		this.nombreReservante = nombreReservante;
		this.telefonoReservante = telefonoReservante;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id.
	 * 
	 * @return id de la reserva.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id de la reserva ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id de la reserva.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo fecha.
	 * 
	 * @return fecha y hora de la reserva.
	 */
	public Date getFechahora() {
		return fechahora;
	}

	/**
	 * M�todo setter del atributo fecha hora <b>post: </b> La fecha y la hora de
	 * la reserva ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param fechahora
	 *            - Fecha y hora de la reserva.
	 */
	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	/**
	 * M�todo getter del atributo comensales.
	 * 
	 * @return comensales de la reserva.
	 */
	public Integer getComensales() {
		return comensales;
	}

	/**
	 * M�todo setter del atributo comensales <b>post: </b> Los comensales de la
	 * reserva ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param comensales
	 *            - Comensales de la reserva.
	 */
	public void setComensales(Integer comensales) {
		this.comensales = comensales;
	}

	/**
	 * M�todo getter del atributo duraci�n.
	 * 
	 * @return duraci�n de la reserva.
	 */
	public Integer getDuracion() {
		return duracion;
	}

	/**
	 * M�todo setter del atributo duraci�n <b>post: </b> La duraci�n de la
	 * reserva ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param duraci�n
	 *            - Duraci�n de la reserva.
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	/**
	 * M�todo getter del atributo nombreReservante.
	 * 
	 * @return Nombre del comensal que hace la reserva.
	 */
	public String getNombreReservante() {
		return nombreReservante;
	}

	/**
	 * M�todo setter del atributo nombreReservante <b>post: </b> El nombre
	 * comensal que hace la reserva ha sido cambiado con el valor que entra como
	 * par�metro.
	 * 
	 * @param nombreReservante
	 *            - Nombre del comensal que hace la reserva.
	 */
	public void setNombreReservante(String nombreReservante) {
		this.nombreReservante = nombreReservante;
	}

	/**
	 * M�todo getter del atributo telefonoReservante.
	 * 
	 * @return Numero telef�nico del comensal que hace la reserva.
	 */
	public Integer getTelefonoReservante() {
		return telefonoReservante;
	}

	/**
	 * M�todo setter del atributo telefonoReservante <b>post: </b> El numero
	 * telef�nico del comensal que hace la reserva ha sido cambiado con el valor
	 * que entra como par�metro.
	 * 
	 * @param telefonoReservante
	 *            - Numero telef�nico del comensal que hace la reserva.
	 */
	public void setTelefonoReservante(Integer telefonoReservante) {
		this.telefonoReservante = telefonoReservante;
	}

}
