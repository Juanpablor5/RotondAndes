package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Espacio.
 */
public class Espacio {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id del espacio.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Indica el acondicionamiento del espacio.
	 */
	@JsonProperty(value = "acondicionamiento")
	private String acondicionamiento;

	/**
	 * Determina si el espacio est� abierto o cerrado.
	 */
	@JsonProperty(value = "abierto")
	private Boolean abierto;

	/**
	 * Indica la capacidad del espacio.
	 */
	@JsonProperty(value = "capacidad")
	private Integer capacidad;

	/**
	 * Indica si el espacio es apto para el ingreso de personas con necesidades
	 * especiales.
	 */
	@JsonProperty(value = "necesidadesEspeciales")
	private Boolean necesidadesEspeciales;

	/**
	 * Indica las condiciones t�cnicas que tiene el espacio.
	 */
	@JsonProperty(value = "condicionesTecnicas")
	private String condicionesTecnicas;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase espacio. <b>post: </b> Crea el espacio con
	 * los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id del espacio.
	 * @param acondicionamiento
	 *            - Acondicionamiento del espacio. nombre != null
	 * @param abierto
	 *            - Determina si el espacio est� abierto o cerrado.
	 * @param capacidad
	 *            - Capacidad del espacio.
	 * @param necesidadesEspeciales
	 *            - Indica si el espacio es apto para el ingreso de personas con
	 *            necesidades especiales.
	 * @param condicionesTecnicas
	 *            - Condiciones t�cnicas que tiene el espacio.
	 */
	public Espacio(@JsonProperty(value = "id") Long id,
			@JsonProperty(value = "acondicionamiento") String acondicionamiento,
			@JsonProperty(value = "abierto") Boolean abierto, @JsonProperty(value = "capacidad") Integer capacidad,
			@JsonProperty(value = "necesidadesEspeciales") Boolean necesidadesEspeciales,
			@JsonProperty(value = "condicionesTecnicas") String condicionesTecnicas) {
		super();
		this.id = id;
		this.acondicionamiento = acondicionamiento;
		this.abierto = abierto;
		this.capacidad = capacidad;
		this.necesidadesEspeciales = necesidadesEspeciales;
		this.condicionesTecnicas = condicionesTecnicas;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * M�todo getter del atributo id.
	 * 
	 * @return id del espacio.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id del espacio ha sido
	 * cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id del espacio.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo acondicionamiento.
	 * 
	 * @return acondicionamiento del espacio.
	 */
	public String getAcondicionamiento() {
		return acondicionamiento;
	}

	/**
	 * M�todo setter del acondicionamiento id <b>post: </b> El acondicionamiento
	 * del espacio ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param acondicionamiento
	 *            - Acondicionamiento del espacio.
	 */
	public void setAcondicionamiento(String acondicionamiento) {
		this.acondicionamiento = acondicionamiento;
	}

	/**
	 * M�todo getter del atributo abierto.
	 * 
	 * @return True si el espacio est� abierto, false de lo contrario.
	 */
	public Boolean getAbierto() {
		return abierto;
	}

	/**
	 * M�todo setter del atributo abierto <b>post: </b> El estado del espacio ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param abierto
	 *            - True si el espacio est� abierto, false de lo contrario.
	 */
	public void setAbierto(Boolean abierto) {
		this.abierto = abierto;
	}

	/**
	 * M�todo getter del atributo capacidad.
	 * 
	 * @return capacidad del espacio.
	 */
	public Integer getCapacidad() {
		return capacidad;
	}

	/**
	 * M�todo setter del atributo capacidad <b>post: </b> La capacidad del
	 * espacio ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param capacidad
	 *            - Capacidad del espacio.
	 */
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * M�todo getter del atributo necesidadesEspeciales.
	 * 
	 * @return necesidadesEspeciales del espacio.
	 */
	public Boolean getNecesidadesEspeciales() {
		return necesidadesEspeciales;
	}

	/**
	 * M�todo setter del atributo necesidadesEspeciales <b>post: </b> El estar
	 * acondicionado para necesidades especiales del espacio ha sido cambiado
	 * con el valor que entra como par�metro.
	 * 
	 * @param necesidadesEspeciales
	 *            - Necesidades especiales del espacio.
	 */
	public void setNecesidadesEspeciales(Boolean necesidadesEspeciales) {
		this.necesidadesEspeciales = necesidadesEspeciales;
	}

	/**
	 * M�todo getter del atributo condicionesTecnicas.
	 * 
	 * @return condicionesTecnicas del espacio.
	 */
	public String getCondicionesTecnicas() {
		return condicionesTecnicas;
	}

	/**
	 * M�todo setter del atributo condicionesTecnicas <b>post: </b> Las
	 * condiciones t�cnicas del espacio ha sido cambiado con el valor que entra
	 * como par�metro.
	 * 
	 * @param condicionesTecnicas
	 *            - Condiciones t�cnicas del espacio.
	 */
	public void setCondicionesTecnicas(String condicionesTecnicas) {
		this.condicionesTecnicas = condicionesTecnicas;
	}
}
