package boulangerie.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("basic")
public class Basique extends Produit{


	
	@Enumerated(EnumType.STRING)
	@Column(name = "category", length = 25)
	private Categorie categorie;
	
	
	public Basique() {
		super();
	}



	
	public Basique(BigDecimal prix, String libelle,Categorie categorie) {
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
