package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import em.Checks;
import em.Check.SISTRANS_Check;
import em.Columna.SISTRANS_Columna;
import em.Foreing.ForeignKey;
import em.Id.SISTRANS_Id;
import em.Reference;
import em.Tabla;

/**
 * Clase que representa un Espacio.
 */
@Tabla
public class Espacio {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------
	@SISTRANS_Id
	@JsonProperty(value = "id")
	private Long id;

	@SISTRANS_Columna(maxSize=500)
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "acondicionamiento")
	private String acondicionamiento;

	@SISTRANS_Columna
	@JsonProperty(value = "abierto")
	private Boolean abierto;

	@SISTRANS_Columna
	@SISTRANS_Check(value=Checks.HIGHER, of="0")
	@JsonProperty(value = "capacidad")
	private Integer capacidad;

	@SISTRANS_Columna
	@JsonProperty(value = "necesidadesEspeciales")
	private Boolean necesidadesEspeciales;

	@SISTRANS_Columna(maxSize=500)
	@SISTRANS_Check(value = Checks.DIFERENT, of = "")
	@JsonProperty(value = "condicionesTecnicas")
	private String condicionesTecnicas;
	
	@Reference
	@ForeignKey(nullable= false, cascade=true)
	private Zona zona;

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
			@JsonProperty(value = "condicionesTecnicas") String condicionesTecnicas,
			Zona zonaId) {
		super();
		this.id = id;
		this.acondicionamiento = acondicionamiento;
		this.abierto = abierto;
		this.capacidad = capacidad;
		this.necesidadesEspeciales = necesidadesEspeciales;
		this.condicionesTecnicas = condicionesTecnicas;
		this.zona = zonaId;
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

	/**
	 * M�todo getter del atributo zonaId.
	 * 
	 * @return zona del espacio.
	 */
	public Zona getZona() {
		return zona;
	}

	/**
	 * M�todo setter del atributo zonaId <b>post: </b> La
	 * zona del espacio ha sido cambiado con el valor que entra
	 * como par�metro.
	 * 
	 * @param zonaId
	 *            - zona del espacio.
	 */
	public void setZona(Zona zonaId) {
		this.zona = zonaId;
	}
}
