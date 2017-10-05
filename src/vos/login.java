package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class login {
	/**
	 * Código representativo de cada cliente.
	 */
	@JsonProperty(value = "contrasena")
	private String contrasena;

	/**
	 * Usuario del cliente.
	 */
	@JsonProperty(value = "usuario")
	private String usuario;
	
	public login( @JsonProperty(value = "usuario") String usuario,
			@JsonProperty(value = "contrasena") String contrasena) {
		this.usuario=usuario;
		this.contrasena=contrasena;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
