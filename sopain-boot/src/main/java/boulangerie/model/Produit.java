package boulangerie.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
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

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

@Entity
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = { "price", "label" }))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Produit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@Version
	@JsonView(Views.ViewBase.class)
	private int version;
	
	@Column(name = "price", precision=5, scale=2)
	@JsonView(Views.ViewBase.class)
	private BigDecimal prix;
	
	@Column(name = "label", length = 25)
	@JsonView(Views.ViewBase.class)
	private String libelle;
	
	@OneToOne(mappedBy = "produit")
	@JsonView(Views.ViewProduit.class)
	private ArticleFavori articlefavoris;
	
	@OneToOne(mappedBy = "produit")
	@JsonView(Views.ViewProduit.class)
	private LigneCommande ligne_commande;
	
	@OneToMany(mappedBy = "produit")
	@JsonView(Views.ViewProduitWithLigneIngredients.class)
	private List<LigneIngredient> ligneIngredients= new ArrayList<>();
	
	
	public Produit() {
		super();
	}


	public Produit(BigDecimal prix, String libelle) {
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


	public BigDecimal getPrix() {
		return prix;
	}



	public void setPrix(BigDecimal prix) {
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


	public ArticleFavori getArticlefavoris() {
		return articlefavoris;
	}


	public void setArticlefavoris(ArticleFavori articlefavoris) {
		this.articlefavoris = articlefavoris;
	}


	public LigneCommande getLigne_commande() {
		return ligne_commande;
	}


	public void setLigne_commande(LigneCommande ligne_commande) {
		this.ligne_commande = ligne_commande;
	}


	public List<LigneIngredient> getLigneIngredients() {
		return ligneIngredients;
	}


	public void setLigneIngredients(List<LigneIngredient> ligneIngredients) {
		this.ligneIngredients = ligneIngredients;
	}

	
	
}
