package model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LigneIngredient {
	
	
	@ManyToOne
	@JoinColumn(name = "Product_id")
	private Ingredient ingredient;
	
	
	@ManyToOne
	@JoinColumn(name = "Ingredient_id")
	private Produit produit;


	
	
	public LigneIngredient() {
		super();
	}


	public Ingredient getIngredient() {
		return ingredient;
	}


	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
	

}
