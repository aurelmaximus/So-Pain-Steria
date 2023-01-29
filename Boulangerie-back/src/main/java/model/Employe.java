package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("employe")
public class Employe extends Compte{
	
	

	public Employe() {
		super();
	}

	
	public Employe(String login, String password, String nom, String prenom, Adresse adresse) {
		super(login, password, nom, prenom, adresse);
	}



}