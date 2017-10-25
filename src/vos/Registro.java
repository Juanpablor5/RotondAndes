package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import em.Check;
import em.Check.SISTRANS_Check;
import em.Checks;
import em.Columna;
import em.Id;
import em.Tabla;
import em.Columna.SISTRANS_Columna;
import em.Id.SISTRANS_Id;
@Tabla
public class Registro {
	// -------------------------------------------------------------
	// ATRIBUTOS
	// -------------------------------------------------------------
	@SISTRANS_Id
	@JsonProperty(value = "codigo")
	private Long codigo;

	@SISTRANS_Columna
	@SISTRANS_Check(value=Checks.DIFERENT,of="")
	@JsonProperty(value = "usuario")
	private String usuario;

	@SISTRANS_Columna
	@SISTRANS_Check(value=Checks.DIFERENT,of="")
	@JsonProperty(value = "contrasenia")
	private String contrasenia;

	@SISTRANS_Columna
	@SISTRANS_Check(value=Checks.BETWEEN, of="0",to="3")
	@JsonProperty(value = "permisos")
	private Integer permisos;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------
	
	public Registro() {
		// TODO Auto-generated constructor stub
	}

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
			@JsonProperty(value = "contrasena") String contrasenia, @JsonProperty(value = "permisos") Integer permisos) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
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
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * Método setter del atributo contraseña <b>post: </b> La contraseña del
	 * cliente a registrar ha sido cambiado con el valor que entra como
	 * parámetro.
	 * 
	 * @param contraseña
	 *            - Contraseña del cliente a registrar.
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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
