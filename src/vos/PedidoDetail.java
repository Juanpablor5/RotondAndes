package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PedidoDetail extends Menu {
	@JsonProperty(value = "menus")
	private List<Long> menus;

	public PedidoDetail(@JsonProperty(value = "id") Long id, @JsonProperty(value = "cantidad") Integer cantidad,
			@JsonProperty(value = "costoProduccion") Double costoProduccion,
			@JsonProperty(value = "valorPublico") Double valorPublico,
			@JsonProperty(value = "productoEntradaId") Long productoEntradaId,
			@JsonProperty(value = "productoPlatoFuerteId") Long productoPlatoFuerteId,
			@JsonProperty(value = "productoPostreId") Long productoPostreId,
			@JsonProperty(value = "productoBebidaId") Long productoBebidaId,
			@JsonProperty(value = "productoAcompanamientoId") Long productoAcompanamientoId,
			@JsonProperty(value = "restauranteId") Long restauranteId,
			@JsonProperty(value = "menus") List<Long> menus) {
		super(id,cantidad, costoProduccion, valorPublico, productoEntradaId, productoPlatoFuerteId, productoPostreId,
				productoBebidaId, productoAcompanamientoId, restauranteId);
		this.menus = menus;
	}
	
	public List<Long> getMenus(){
		return menus;
	}
	
	public void setMenus(List<Long> menus){
		this.menus = menus;
	}
}
