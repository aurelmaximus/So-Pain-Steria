package model;

public enum Gateaux {
	
	Eclair(2.70), Paris_Brest(2.80), Fraisier(3.10), Tarte_Framboise(3),
	Mille_Feuille(2.80), Choux_Crême(2.90), Relegieuse(2.80), Amandine(2.70);
	
	
	private double prix;
	
	private Gateaux(double prix)
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
