package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("Basic")
public class Basique extends Produit{

	
	@Column(name = "Category)")
	private Categorie categorie;
	
	@Version
	private Integer version;

	
	public Basique() {
		super();
	}

	public Basique(Categorie categorie) {
		super();
		this.categorie = categorie;
	}

	
	public Categorie getCategorie() {
		return categorie;
	}

	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	public int getVersion() {
		return version;
	}
	

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
	
}
