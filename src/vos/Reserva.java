package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import em.Checks;
import em.DateAnotation;
import em.Check.SISTRANS_Check;
import em.Columna.SISTRANS_Columna;
import em.Foreing.ForeignKey;
import em.Id.SISTRANS_Id;
import em.Reference;
import em.Tabla;

/**
 * Clase que representa un Producto.
 */
@Tabla
public class Reserva {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	@SISTRANS_Id(AutoIncrement = true)
	@JsonProperty(value = "id")
	private Long id;

	@SISTRANS_Columna(valorPorDefecto = "SYSDATE")
	@DateAnotation(completa = true)
	@JsonProperty(value = "fechahora")
	private String fechahora;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.HIGHER, of = "0")
	@JsonProperty(value = "duracion")
	private Integer duracion;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.HIGHER, of = "0")
	@JsonProperty(value = "comensales")
	private Integer comensales;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "nombreReservante")
	private String nombreReservante;

	@SISTRANS_Columna
	@SISTRANS_Check(value = Checks.HIGHER, of = "0")
	@JsonProperty(value = "telefonoReservante")
	private Long telefonoReservante;

	@Reference
	@ForeignKey
	private Zona zona;

	@Reference
	@ForeignKey
	private Menu menu;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase Reserva. <b>post: </b> Crea el producto con
	 * los valores que entran como par�metro.
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
	public String getFechahora() {
		return fechahora;
	}

	/**
	 * M�todo setter del atributo fecha hora <b>post: </b> La fecha y la hora de la
	 * reserva ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param fechahora
	 *            - Fecha y hora de la reserva.
	 */
	public void setFechahora(String fechahora) {
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
	 * M�todo setter del atributo duraci�n <b>post: </b> La duraci�n de la reserva
	 * ha sido cambiado con el valor que entra como par�metro.
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
	 * M�todo setter del atributo nombreReservante <b>post: </b> El nombre comensal
	 * que hace la reserva ha sido cambiado con el valor que entra como par�metro.
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
	public Long getTelefonoReservante() {
		return telefonoReservante;
	}

	/**
	 * M�todo setter del atributo telefonoReservante <b>post: </b> El numero
	 * telef�nico del comensal que hace la reserva ha sido cambiado con el valor que
	 * entra como par�metro.
	 * 
	 * @param telefonoReservante
	 *            - Numero telef�nico del comensal que hace la reserva.
	 */
	public void setTelefonoReservante(Long telefonoReservante) {
		this.telefonoReservante = telefonoReservante;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
