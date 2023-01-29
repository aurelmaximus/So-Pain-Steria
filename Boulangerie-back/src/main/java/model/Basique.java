package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("basic")
public class Basique extends Produit{

	
	@Column(name = "category")
	private Categorie categorie;
	
	
	public Basique() {
		super();
	}



	
	public Basique(double prix, String libelle,Categorie categorie) {
		super(prix, libelle);
		this.categorie=categorie;
		
	}




	public Categorie getCategorie() {
		return categorie;
	}

	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
}
