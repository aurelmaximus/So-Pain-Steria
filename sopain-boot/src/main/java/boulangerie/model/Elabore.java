package boulangerie.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("elaborate")
public class Elabore extends Produit {

	@Column(name = "share_number")
	private Integer NbParts;
	

	public Elabore() {
		super();
	}


	public Elabore(BigDecimal prix, String libelle, Integer NbParts) {
		super(prix, libelle);
		this.NbParts=NbParts;
	}


	public Integer getNbParts() {
		return NbParts;
	}


	public void setNbParts(Integer nbParts) {
		NbParts = nbParts;
	}


	@Override
	public String toString() {
		return "Elabore : "+ super.getLibelle() +" "+ super.getPrix() + " [NbParts=" + NbParts + "]";
	}


}
