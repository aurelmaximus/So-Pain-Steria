package boulangerie.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@DiscriminatorValue("employe")
@JsonView(Views.ViewBase.class)
public class Employe extends Compte{
	
	

	public Employe() {
		super();
	}

	
	public Employe(String email, String password, String nom, String prenom, Adresse adresse) {
		super(email, password, nom, prenom, adresse);
	}



}