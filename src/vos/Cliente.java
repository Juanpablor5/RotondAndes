package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Cliente.
 */
public class Cliente {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * C�dula del cliente.
	 */
	@JsonProperty(value = "cedula")
	private Long cedula;

	/**
	 * Nombre del cliente.
	 */
	@JsonProperty(value = "nombre")
	private String nombre;

	/**
	 * Fecha de ingreso del cliente.
	 */
	@JsonProperty(value = "fechaIngreso")
	private Date fechaIngreso;
	
	/**
	 * id del registro asociado
	 */
	@JsonProperty(value = "regristroId")
	private Integer regristroId;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase cliente. <b>post: </b> Crea el cliente con
	 * los valores que entran como par�metro.
	 * 
	 * @param cedula
	 *            - C�dula del cliente.
	 * @param nombre
	 *            - Nombre del cliente. nombre != null
	 * @param fechaIngreso
	 *            - Fecha de ingreso del cliente.
	 * @param regristroId 
	 */
	public Cliente(@JsonProperty(value = "cedula") Long cedula, @JsonProperty(value = "nombre") String nombre,
			@JsonProperty(value = "fechaIngreso") Date fechaIngreso, @JsonProperty(value = "regristroId") Integer regristroId) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.regristroId= regristroId;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id
	 * 
	 * @return id del cliente
	 */
	public Long getCedula() {
		return cedula;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del cliente ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del cliente
	 */
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	/**
	 * M�todo getter del atributo nombre
	 * 
	 * @return id del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo setter del atributo nombre <b>post: </b> El nombre del cliente ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param nombre
	 *            - Nombre del cliente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M�todo getter del atributo fechaIngreso.
	 * 
	 * @return fecha de ingreso del cliente.
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * M�todo setter del atributo fehchaIngreso <b>post: </b> La fecha de
	 * ingreso del cliente ha sido cambiado con el valor que entra como
	 * par�metro.
	 * 
	 * @param fechaIngreso
	 *            - Fecha de ingreso del cliente.
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	/**
	 * dar el id del reistro asociado
	 * @return
	 */
	public Integer getRegristroId() {
		return regristroId;
	}
	
	/**
	 * cambiar el id del registro asociado
	 * @param regristroId
	 */
	public void setRegristroId(Integer regristroId) {
		this.regristroId = regristroId;
	}
}
