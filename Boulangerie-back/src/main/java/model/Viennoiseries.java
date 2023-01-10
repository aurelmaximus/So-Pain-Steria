package model;

public enum Viennoiseries {
	
	Croissant(1.10) , Chocolatine(1.20) , Pain_Aux_Raisin(1.40), Chouquette (0.20),
	Chausson_Aux_Pommes (1.80), Brioche_Suisse(1.80), Briochette_Aux_Chocolat (1.40),
	Canelés(1.60);
	
	private double prix;
	
	private Viennoiseries (double prix)
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
