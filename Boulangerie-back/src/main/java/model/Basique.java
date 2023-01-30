package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("basic")
public class Basique extends Produit{

	
	@Column(name = "category")
	@Enumerated
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




	@Override
	public String toString() {
		return "Basique : "+ super.getLibelle() +" "+ super.getPrix() + " [categorie=" + categorie + "]";
	}
	
	
	
}
