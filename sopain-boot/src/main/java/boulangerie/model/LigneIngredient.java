package boulangerie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "ingredient_line")
public class LigneIngredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@Version
	@JsonView(Views.ViewBase.class)
	private int version;
	
	@ManyToOne
	@JoinColumn(name = "ingredient_id", referencedColumnName = "id")
	@JsonView(Views.ViewBase.class)
	private Ingredient ingredient;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	@JsonView(Views.ViewBase.class)
	private Produit produit;


	
	
	public LigneIngredient() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
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


	@Override
	public String toString() {
		return "LigneIngredient [id=" + id + ", version=" + version + ", ingredient=" + ingredient + ", produit="
				+ produit + "]";
	}

	

}
