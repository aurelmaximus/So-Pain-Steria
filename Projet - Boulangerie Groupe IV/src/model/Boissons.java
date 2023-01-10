package model;

public enum Boissons {

	Expresso(2), Coca(2), Cristaline(1.50),Jus_Fruits(2.5),
	Thé_Menthe(1.5), Oasis(2), Orangina(2), Ice_Tea(2);
	
	private double prix;
	
	private Boissons(double prix)
	{
		this.prix=prix;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
