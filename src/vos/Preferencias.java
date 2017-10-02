package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un Producto.
 */
public class Preferencias {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Id de la preferencia.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * El mayor precio con el que se desea filtrar.
	 */
	@JsonProperty(value = "precioMenor")
	private Double precioMenor;

	/**
	 * El menor precio con el que se desea filtrar.
	 */
	@JsonProperty(value = "precioMayor")
	private Double precioMayor;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * M�todo constructor de la clase producto. <b>post: </b> Crea el producto
	 * con los valores que entran como par�metro.
	 * 
	 * @param id
	 *            - Id de la preferencia.
	 * @param precioMayor
	 *            - El mayor precio con el que se desea filtrar.
	 * @param precioMenor
	 *            - El menor precio con el que se desea filtrar.
	 */
	public Preferencias(@JsonProperty(value = "id") Long id, @JsonProperty(value = "precioMayor") Double precioMayor,
			@JsonProperty(value = "precioMenor") Double precioMenor) {
		super();
		this.id = id;
		this.precioMayor = precioMayor;
		this.precioMenor = precioMenor;
	}

	/**
	 * M�todo getter del atributo id
	 * 
	 * @return id de la preferencia
	 */
	public Long getId() {
		return id;
	}

	/**
	 * M�todo setter del atributo id <b>post: </b> El id de la preferencia ha
	 * sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param id
	 *            - Id de la preferencia
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * M�todo getter del atributo precioMenor
	 * 
	 * @return Menor precio al cual filtrar.
	 */
	public Double getPrecioMenor() {
		return precioMenor;
	}

	/**
	 * M�todo setter del atributo precioMenor <b>post: </b> El precio menor de
	 * la preferencia ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param precioMenor
	 *            - Precio menor de la preferencia.
	 */
	public void setPrecioMenor(Double precioMenor) {
		this.precioMenor = precioMenor;
	}

	/**
	 * M�todo getter del atributo precioMayor
	 * 
	 * @return Mayor precio al cual filtrar.
	 */
	public Double getPrecioMayor() {
		return precioMayor;
	}

	/**
	 * M�todo setter del atributo precioMayor <b>post: </b> El precio mayor de
	 * la preferencia ha sido cambiado con el valor que entra como par�metro.
	 * 
	 * @param precioMayor
	 *            - Precio mayor de la preferencia.
	 */
	public void setPrecioMayor(Double precioMayor) {
		this.precioMayor = precioMayor;
	}

}
