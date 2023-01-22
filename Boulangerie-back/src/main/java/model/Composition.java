package model;

public class Composition {

	private int qte;

	public Composition(int qte) {
		super();
		this.qte = qte;
	}
	

	public Composition(Integer qte) {
		super();
		this.qte = qte;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	@Override
	public String toString() {
		return "Composition [qte=" + qte + "]";
	}
	
	
}
