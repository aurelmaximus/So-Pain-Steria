package boulangerie.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name ="ingredient")

public class Ingredient implements Serializable   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private Integer version;
	
	@Column(name="allergen", columnDefinition = "tinyint(1) default 0")
	private boolean allergene;
	
	@Column(name="label", length = 25)
	private String libelle;
	

	@OneToMany(mappedBy = "ingredient")
	private List<LigneIngredient> lignesIngredient= new ArrayList<>();
	
	
	public Ingredient() {
		super();
	}


	public Ingredient(String libelle,boolean allergene) {
		super();
		this.allergene = allergene;
		this.libelle = libelle;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public boolean isAllergene() {
		return allergene;
	}


	public void setAllergene(boolean allergene) {
		this.allergene = allergene;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public List<LigneIngredient> getLigneIngredients() {
		return lignesIngredient;
	}


	public void setLigneIngredients(List<LigneIngredient> ligneIngredients) {
		this.lignesIngredient = ligneIngredients;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	@Override
	public String toString() {
		return "Ingredient [allergene=" + allergene + ", libelle=" + libelle + "]";
	}



}
