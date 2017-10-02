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
	 * Método constructor de la clase Reserva. <b>post: </b> Crea el producto
	 * con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id de la reserva.
	 * @param fecha
	 *            - Fecha de la reserva.
	 * @param hora
	 *            - Hora de la reserva.
	 * @param comensales
	 *            - Comensales de descripción de la reserva.
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
	 * @return id de la reserva.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Método setter del atributo fecha <b>post: </b> La fecha de la reserva ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param fecha
	 *            - Fecha de la reserva.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Método getter del atributo hora.
	 * 
	 * @return hora de la reserva.
	 */
	public Date getHora() {
		return hora;
	}

	/**
	 * Método setter del atributo hora <b>post: </b> La hora de la reserva ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param hora
	 *            - Hora de la reserva.
	 */
	public void setHora(Date hora) {
		this.hora = hora;
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
	 * Método setter del atributo comensales <b>post: </b> Los comensales de la reserva ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param comensales
	 *            - Comensales de la reserva.
	 */
	public void setComensales(Integer comensales) {
		this.comensales = comensales;
	}
}
