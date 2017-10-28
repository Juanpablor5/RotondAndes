package vos;

import em.Foreing.ForeignKey;
import em.Id.SISTRANS_Id;

public class IngredienteSimilitud {
	
	@SISTRANS_Id(AutoIncrement=true)
	private Long id;
	
	@ForeignKey
	private Restaurante restaurante;
	
	@ForeignKey
	private Ingrediente ingrediente;
	
	@ForeignKey
	private Ingrediente ingrediente2;
	
	public IngredienteSimilitud() {
		// TODO Auto-generated constructor stub
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public Ingrediente getIngrediente2() {
		return ingrediente2;
	}
	public void setIngrediente2(Ingrediente ingrediente2) {
		this.ingrediente2 = ingrediente2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
