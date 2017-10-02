package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Registro.
 */
public class Registro {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Código representativo de cada cliente.
	 */
	@JsonProperty(value = "codigo")
	private Long codigo;

	/**
	 * Usuario del cliente.
	 */
	@JsonProperty(value = "usuario")
	private String usuario;

	/**
	 * Contraseña del usuario.
	 */
	@JsonProperty(value = "contrasena")
	private String contrasena;

	/**
	 * Permisos que tiene cada cliente representados por números.
	 */
	@JsonProperty(value = "permisos")
	private Integer permisos;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Método constructor de la clase Registro. <b>post: </b> Crea el cliente a
	 * registrar con los valores que entran como parámetro.
	 * 
	 * @param codigo
	 *            - Id del cliente a registrar.
	 * @param usuario
	 *            - Nombre del cliente a registrar. usuario != null
	 * @param contraseña
	 *            - Descripción del cliente a registrar. contraseña != null
	 * @param permisos
	 *            - Traducción de descripción del cliente a registrar.
	 */
	public Registro(@JsonProperty(value = "codigo") Long codigo, @JsonProperty(value = "usuario") String usuario,
			@JsonProperty(value = "contrasena") String contrasena, @JsonProperty(value = "permisos") Integer permisos) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.permisos = permisos;
	}

	// -------------------------------------------------------------
	// Getters & Setters
	// -------------------------------------------------------------

	/**
	 * Método getter del atributo código.
	 * 
	 * @return Código del cliente a registrar.
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo código <b>post: </b> El código del cliente a
	 * registrar ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param código
	 *            - Código del cliente a registrar.
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo usuario.
	 * 
	 * @return usuario del cliente a registrar.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Método setter del atributo usuario <b>post: </b> El usuario del cliente a
	 * registrar ha sido cambiado con el valor que entra como parámetro.
	 * 
	 * @param usuario
	 *            - Usuario del cliente a registrar.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Método getter del atributo contraseña.
	 * 
	 * @return Contraseña del cliente a registrar.
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Método setter del atributo contraseña <b>post: </b> La contraseña del
	 * cliente a registrar ha sido cambiado con el valor que entra como
	 * parámetro.
	 * 
	 * @param contraseña
	 *            - Contraseña del cliente a registrar.
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Método getter del atributo permisos.
	 * 
	 * @return id del cliente a registrar.
	 */
	public Integer getPermisos() {
		return permisos;
	}

	/**
	 * Método setter del atributo permisos <b>post: </b> Los permisos del
	 * cliente a registrar ha sido cambiado con el valor que entra como
	 * parámetro.
	 * 
	 * @param permisos
	 *            - Permisos del cliente a registrar.
	 */
	public void setPermisos(Integer permisos) {
		this.permisos = permisos;
	}
}
