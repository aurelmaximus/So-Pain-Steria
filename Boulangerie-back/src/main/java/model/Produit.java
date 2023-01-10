package model;

public class Produit {

	private Integer id;
	private double prix;
	private Integer stock;
	private String libelle;
	
	
	public Produit(double prix, int stock, String libelle) {
		super();
		this.prix = prix;
		this.stock = stock;
		this.libelle = libelle;
	}
	
	public Produit(Integer id, double prix, Integer stock, String libelle) {
		super();
		this.prix = prix;
		this.stock = stock;
		this.libelle = libelle;
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


	@Override
	public String toString() {
		return "Produit [prix=" + prix + ", stock=" + stock + ", libelle=" + libelle + "]";
	}
	
	
	
}
