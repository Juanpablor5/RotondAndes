package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PedidoDetail extends Pedido {
	@JsonProperty(value = "menus")
	private List<Long> menus;

	public PedidoDetail(@JsonProperty(value = "id") Long id, @JsonProperty(value = "fechahora") String fechahora,
			@JsonProperty(value = "clienteCedula") Integer clienteCedula,
			@JsonProperty(value = "menus") List<Long> menus) {
		super(id, fechahora, clienteCedula);
		this.menus = menus;
	}
	
	public List<Long> getMenus(){
		return menus;
	}
	
	public void setMenus(List<Long> menus){
		this.menus = menus;
	}
}
