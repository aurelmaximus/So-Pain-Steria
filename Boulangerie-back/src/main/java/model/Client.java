package model;

public class Client extends Compte {

	public Client(String login, String password, String nom, String prenom, Adresse adresse) {
		super(login, password, nom, prenom, adresse);

	}

	public Client(Integer id,String login, String password, String nom, String prenom, Adresse adresse) {
		super(login, password, nom, prenom, adresse);

	}

	
	public String toString() {
		return "Client [login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + "]";
	}

	
}
