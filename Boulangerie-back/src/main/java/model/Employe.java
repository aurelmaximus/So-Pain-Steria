package model;

public class Employe extends Compte{

	protected Metier metier;

	public Employe(Integer id,String login, String password, String nom, String prenom, Adresse adresse, Metier metier) {
		super(login, password, nom, prenom, adresse);
		this.metier = metier;
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

	@Override
	public String toString() {
		return "Employe [metier=" + metier + ", login=" + login + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}



}