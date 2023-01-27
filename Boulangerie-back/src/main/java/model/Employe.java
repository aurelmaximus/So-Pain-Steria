package model;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("employe")
public class Employe extends Compte{
	@Column(name="job")
	private Metier metier;
	
	
	public Employe() {
		super();
	}

	
	public Employe(String login, String password, String nom, String prenom, Adresse adresse, Metier metier) {
		super(login, password, nom, prenom, adresse);
		this.metier = metier;
	}
	
	
	
	public Metier getMetier() {
		return metier;
	}

	
	public void setMetier(Metier metier) {
		this.metier = metier;
	}



}