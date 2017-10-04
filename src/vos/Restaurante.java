package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Restaurante.
 */
public class Restaurante {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id del restaurante.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Nombre del restaurante.
	 */
	@JsonProperty(value = "nombre")
	private String nombre;

	/**
	 * URL de la página web del restaurante.
	 */
	@JsonProperty(value = "paginaWeb")
	private String paginaWeb;

	/**
	 * id del tipo de comida asociado.
	 */
	@JsonProperty(value = "tipoComidaId")
	private Integer tipoComidaId;

	/**
	 * id del registro asociado.
	 */
	@JsonProperty(value = "regristroId")
	private Integer regristroId;

	/**
	 * Id de la zona del restaurante.
	 */
	@JsonProperty(value = "regristroId")
	private Integer zonaId;

	/**
	 * Método constructor de la clase restaurante. <b>post: </b> Crea el
	 * restaurante con los valores que entran como parámetro.
	 * 
	 * @param id
	 *            - Id del restaurante.
	 * @param nombre
	 *            - Nombre del restaurante. nombre != null
	 * @param paginaWeb
	 *            - URL de la página web del restaurante.
	 */
	public Restaurante(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre,
			@JsonProperty(value = "paginaWeb") String paginaWeb,
			@JsonProperty(value = "tipoComidaId") Integer tipoComidaId,
			@JsonProperty(value = "regristroId") Integer regristroId,
			@JsonProperty(value = "zonaId") Integer zonaId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.paginaWeb = paginaWeb;
		this.tipoComidaId = tipoComidaId;
		this.regristroId = regristroId;
		this.zonaId = zonaId;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo id.
	 * 
	 * @return id del restaurante.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método setter del atributo id <b>post: </b> El id del restaurante ha sido
	 * cambiado con el valor que entra como parámetro.
	 * 
	 * @param id
	 *            - Id del restaurante.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre.
	 * 
	 * @return id del restaurante.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre <b>post: </b> El nombre del restaurante
	 * ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param nombre
	 *            - Nombre del restaurante.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo paginaWeb.
	 * 
	 * @return URL de la página web del restaurante.
	 */
	public String getPaginaWeb() {
		return paginaWeb;
	}

	/**
	 * Método setter del atributo paginaWeb <b>post: </b> El URL de la página
	 * web del restaurante ha sido cambiado con el valor que entra como
	 * parámetro.
	 * 
	 * @param nombre
	 *            - Nombre del restaurante.
	 */
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	/**
	 * dar el id del reistro asociado
	 * 
	 * @return
	 */
	public Integer getRegristroId() {
		return regristroId;
	}

	/**
	 * cambiar el id del registro asociado
	 * 
	 * @param regristroId
	 */
	public void setRegristroId(Integer regristroId) {
		this.regristroId = regristroId;
	}

	/**
	 * Dar el tipo de comida del restaurante
	 * 
	 * @return tipoComidaId
	 */
	public Integer getTipoComidaId() {
		return tipoComidaId;
	}

	/**
	 * Cambiar el tipo de comida
	 * 
	 * @param regristroId
	 */
	public void setTipoComidaId(Integer tipoComidaId) {
		this.tipoComidaId = tipoComidaId;
	}

	/**
	 * Dar la zona del restaurante.
	 * 
	 * @return zonaId
	 */
	public Integer getZonaId() {
		return zonaId;
	}

	/**
	 * Cambiar la zona del restaurante
	 * 
	 * @param regristroId
	 */
	public void setZonaId(Integer zonaId) {
		this.zonaId = zonaId;
	}
	
	
}
