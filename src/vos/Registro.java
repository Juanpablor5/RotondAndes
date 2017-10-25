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
	 * M�todo constructor de la clase Registro. <b>post: </b> Crea el cliente a
	 * registrar con los valores que entran como par�metro.
	 * 
	 * @param codigo
	 *            - Id del cliente a registrar.
	 * @param usuario
	 *            - Nombre del cliente a registrar. usuario != null
	 * @param contrase�a
	 *            - Descripci�n del cliente a registrar. contrase�a != null
	 * @param permisos
	 *            - Traducci�n de descripci�n del cliente a registrar.
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
	 * M�todo getter del atributo c�digo.
	 * 
	 * @return C�digo del cliente a registrar.
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * M�todo setter del atributo c�digo <b>post: </b> El c�digo del cliente a
	 * registrar ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param c�digo
	 *            - C�digo del cliente a registrar.
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo getter del atributo usuario.
	 * 
	 * @return usuario del cliente a registrar.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * M�todo setter del atributo usuario <b>post: </b> El usuario del cliente a
	 * registrar ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param usuario
	 *            - Usuario del cliente a registrar.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * M�todo getter del atributo contrase�a.
	 * 
	 * @return Contrase�a del cliente a registrar.
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * M�todo setter del atributo contrase�a <b>post: </b> La contrase�a del
	 * cliente a registrar ha sido cambiado con el valor que entra como
	 * par�metro.
	 * 
	 * @param contrase�a
	 *            - Contrase�a del cliente a registrar.
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * M�todo getter del atributo permisos.
	 * 
	 * @return id del cliente a registrar.
	 */
	public Integer getPermisos() {
		return permisos;
	}

	/**
	 * M�todo setter del atributo permisos <b>post: </b> Los permisos del
	 * cliente a registrar ha sido cambiado con el valor que entra como
	 * par�metro.
	 * 
	 * @param permisos
	 *            - Permisos del cliente a registrar.
	 */
	public void setPermisos(Integer permisos) {
		this.permisos = permisos;
	}
}
