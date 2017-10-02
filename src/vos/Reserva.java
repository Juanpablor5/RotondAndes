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
	private Date fecha;
	
	/**
	 * Hora de la reserva.
	 */
	@JsonProperty(value = "hora")
	private Date hora;
	
	/**
	 * Numero de comensales de la reserva.
	 */
	@JsonProperty(value = "comensales")
	private Integer comensales;
	
	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase Reserva. <b>post: </b> Crea el producto
	 * con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id de la reserva.
	 * @param fecha
	 *            - Fecha de la reserva.
	 * @param hora
	 *            - Hora de la reserva.
	 * @param comensales
	 *            - Comensales de descripci�n de la reserva.
	 */
	public Reserva(@JsonProperty(value = "id") Long id, @JsonProperty(value = "fecha") Date fecha,
			@JsonProperty(value = "hora") Date hora,
			@JsonProperty(value = "comensales") Integer comensales) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.comensales = comensales;
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
	 * @return id de la reserva.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * M�todo setter del atributo fecha <b>post: </b> La fecha de la reserva ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param fecha
	 *            - Fecha de la reserva.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * M�todo getter del atributo hora.
	 * 
	 * @return hora de la reserva.
	 */
	public Date getHora() {
		return hora;
	}

	/**
	 * M�todo setter del atributo hora <b>post: </b> La hora de la reserva ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param hora
	 *            - Hora de la reserva.
	 */
	public void setHora(Date hora) {
		this.hora = hora;
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
	 * M�todo setter del atributo comensales <b>post: </b> Los comensales de la reserva ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param comensales
	 *            - Comensales de la reserva.
	 */
	public void setComensales(Integer comensales) {
		this.comensales = comensales;
	}
}
