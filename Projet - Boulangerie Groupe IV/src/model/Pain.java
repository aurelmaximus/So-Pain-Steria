package model;

public enum Pain {

	Baguette_Classique(1), Baguette_Tradition(1.20), Pain_Campagne (2.20),
	Pain_Complet(2.20), Pain_6_Céréales(2.20), Baguette_Sésame(1.80),
	Pain_Burger(1.50), Pain_Aux_Noix(3);
	
	private double prix;
	
	private Pain (double prix)
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
