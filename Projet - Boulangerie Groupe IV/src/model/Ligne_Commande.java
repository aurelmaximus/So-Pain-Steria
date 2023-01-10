package model;

import java.time.LocalTime;

public class Ligne_Commande extends Commande{

	private int qte;
	private double total;
	
	
	
	public Ligne_Commande(Client client, LocalTime heure, LocalTime minute, boolean termine, int qte, double total) {
		super(client, heure, minute, termine);
		this.qte = qte;
		this.total = total;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Ligne_Commande [qte=" + qte + ", total=" + total + "]";
	}
	
	
	
}
