package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ProductoDetail extends Producto {
	@JsonProperty(value = "ingredientes")
	private List<Long> ingredientes;

	public ProductoDetail(@JsonProperty(value = "id") Long id, @JsonProperty(value = "nombre") String nombre,
			@JsonProperty(value = "descripcion") String descripcion,
			@JsonProperty(value = "traduccion") String traduccion,
			@JsonProperty(value = "tiempoPreparacion") Integer tiempoPreparacion,
			@JsonProperty(value = "idCategoria") Long idCategoria,
			@JsonProperty(value = "ingredientes") List<Long> ingredientes) {
		super(id, nombre, descripcion, traduccion, tiempoPreparacion, idCategoria);
		this.ingredientes = ingredientes;
	}

	public List<Long> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Long> ingredientes) {
		this.ingredientes = ingredientes;
	}
}
