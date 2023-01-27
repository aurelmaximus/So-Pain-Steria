package model;

public abstract class Compte {

	protected Integer id;
	protected String login;
	protected String password;
	protected String nom;
	protected String prenom;
	protected Adresse adresse;
	
	
	
	public Compte() {
		super();
	}


	public Compte(String login, String password, String nom, String prenom, Adresse adresse) {
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	
}
