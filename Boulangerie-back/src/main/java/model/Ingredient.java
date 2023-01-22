package model;

public class Ingredient extends Composition {

	private Integer id;
	private boolean allergene;
	private String libelle;

	public Ingredient(String libelle, int qte, boolean allergene) {
		super(qte);
		this.allergene = allergene;
		this.libelle = libelle;
	}

	public Ingredient(Integer id, String libelle, Integer qte, boolean allergene) {
		super(qte);
		this.allergene = allergene;
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public boolean isAllergene() {
		return allergene;
	}

	public void setAllergene(boolean allergene) {
		this.allergene = allergene;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", allergene=" + allergene + ", libelle=" + libelle + "]";
	}



}
