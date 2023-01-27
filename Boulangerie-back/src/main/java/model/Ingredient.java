package model;

//Pret pour Mapping
public class Ingredient  {

	private Integer id;
	private boolean allergene;
	private String libelle;
	
	
	public Ingredient() {
		super();
	}


	public Ingredient(boolean allergene, String libelle) {
		super();
		this.allergene = allergene;
		this.libelle = libelle;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public boolean isAllergene() {
		return allergene;
	}


	public void setAllergene(boolean allergene) {
		this.allergene = allergene;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	


}
