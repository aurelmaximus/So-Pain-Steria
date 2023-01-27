package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public  abstract class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private Integer version;
	
	
	@Column(name = "Price", length = 4)
	private double prix;
	
	@Column(name = "Label", length = 25)
	private String libelle;
	
	@OneToOne(mappedBy = "Produit", fetch = FetchType.LAZY)
	private ArticleFavoris articlefavoris;
	
	@OneToOne(mappedBy = "Produit", fetch = FetchType.LAZY)
	private Ligne_Commande ligne_commande;
	
	@OneToMany(mappedBy = "Ingredient")
	private List<Ligne_Ingredient> LigneIngredient= new ArrayList<>();
	
	public Produit() {
		super();
	}

	
	public Produit(double prix, String libelle, Categorie categorie) {
		super();
		this.prix = prix;
		this.libelle = libelle;
	}



	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public ArticleFavoris getArticlefavoris() {
		return articlefavoris;
	}


	public void setArticlefavoris(ArticleFavoris articlefavoris) {
		this.articlefavoris = articlefavoris;
	}


	public Ligne_Commande getLigne_commande() {
		return ligne_commande;
	}


	public void setLigne_commande(Ligne_Commande ligne_commande) {
		this.ligne_commande = ligne_commande;
	}


	public List<Ingredient> getListeIngredients() {
		return listeIngredients;
	}


	public void setListeIngredients(List<Ingredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}



	
	
}
