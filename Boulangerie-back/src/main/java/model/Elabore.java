package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("Elaborate")
public class Elabore {

	@Column(name = "Share_Number)")
	private int NbParts;
	
	@Version
	private Integer version;

	public Elabore() {
		super();
	}

	
	public Elabore(int nbParts) {
		super();
		NbParts = nbParts;
	}

	
	public int getNbParts() {
		return NbParts;
	}

	
	public void setNbParts(int nbParts) {
		NbParts = nbParts;
	}

	
	public int getVersion() {
		return version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
}
