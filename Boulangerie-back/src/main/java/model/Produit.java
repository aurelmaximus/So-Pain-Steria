package model;


//Pret pour Mapping
public class Produit {

	private Integer id;
	private double prix;
	private Integer stock;
	private String libelle;
	private Categorie categorie;
	
	
	
	public Produit() {
		super();
	}

	
	public Produit(double prix, Integer stock, String libelle, Categorie categorie) {
		super();
		this.prix = prix;
		this.stock = stock;
		this.libelle = libelle;
		this.categorie = categorie;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	
}
