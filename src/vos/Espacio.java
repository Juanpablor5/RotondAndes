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
	 * Determina si el espacio está abierto o cerrado.
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
	 * Indica las condiciones técnicas que tiene el espacio.
	 */
	@JsonProperty(value = "condicionesTecnicas")
	private String condicionesTecnicas;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase espacio. <b>post: </b> Crea el espacio con
	 * los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del espacio.
	 * @param acondicionamiento
	 *            - Acondicionamiento del espacio. nombre != null
	 * @param abierto
	 *            - Determina si el espacio está abierto o cerrado.
	 * @param capacidad
	 *            - Capacidad del espacio.
	 * @param necesidadesEspeciales
	 *            - Indica si el espacio es apto para el ingreso de personas con
	 *            necesidades especiales.
	 * @param condicionesTecnicas
	 *            - Condiciones técnicas que tiene el espacio.
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
	 * Método getter del atributo id.
	 * 
	 * @return id del espacio.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del espacio ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del espacio.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo acondicionamiento.
	 * 
	 * @return acondicionamiento del espacio.
	 */
	public String getAcondicionamiento() {
		return acondicionamiento;
	}

	/**
	 * Método setter del acondicionamiento id <b>post: </b> El acondicionamiento
	 * del espacio ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param acondicionamiento
	 *            - Acondicionamiento del espacio.
	 */
	public void setAcondicionamiento(String acondicionamiento) {
		this.acondicionamiento = acondicionamiento;
	}

	/**
	 * Método getter del atributo abierto.
	 * 
	 * @return True si el espacio está abierto, false de lo contrario.
	 */
	public Boolean getAbierto() {
		return abierto;
	}

	/**
	 * Método setter del atributo abierto <b>post: </b> El estado del espacio ha
	 * sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param abierto
	 *            - True si el espacio está abierto, false de lo contrario.
	 */
	public void setAbierto(Boolean abierto) {
		this.abierto = abierto;
	}

	/**
	 * Método getter del atributo capacidad.
	 * 
	 * @return capacidad del espacio.
	 */
	public Integer getCapacidad() {
		return capacidad;
	}

	/**
	 * Método setter del atributo capacidad <b>post: </b> La capacidad del
	 * espacio ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param capacidad
	 *            - Capacidad del espacio.
	 */
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Método getter del atributo necesidadesEspeciales.
	 * 
	 * @return necesidadesEspeciales del espacio.
	 */
	public Boolean getNecesidadesEspeciales() {
		return necesidadesEspeciales;
	}

	/**
	 * Método setter del atributo necesidadesEspeciales <b>post: </b> El estar
	 * acondicionado para necesidades especiales del espacio ha sido cambiado
	 * con el valor que entra como parámetro.
	 * 
	 * @param necesidadesEspeciales
	 *            - Necesidades especiales del espacio.
	 */
	public void setNecesidadesEspeciales(Boolean necesidadesEspeciales) {
		this.necesidadesEspeciales = necesidadesEspeciales;
	}

	/**
	 * Método getter del atributo condicionesTecnicas.
	 * 
	 * @return condicionesTecnicas del espacio.
	 */
	public String getCondicionesTecnicas() {
		return condicionesTecnicas;
	}

	/**
	 * Método setter del atributo condicionesTecnicas <b>post: </b> Las
	 * condiciones técnicas del espacio ha sido cambiado con el valor que entra
	 * como parámetro.
	 * 
	 * @param condicionesTecnicas
	 *            - Condiciones técnicas del espacio.
	 */
	public void setCondicionesTecnicas(String condicionesTecnicas) {
		this.condicionesTecnicas = condicionesTecnicas;
	}
}
