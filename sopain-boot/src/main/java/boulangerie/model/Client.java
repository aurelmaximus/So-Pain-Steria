package boulangerie.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

//Pret pour Mapping

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@DiscriminatorValue("customer")
@JsonView(Views.ViewBase.class)
public class Client extends Compte {

	
	@Column(name="points")
	private int points;
	
	//ICI
	@OneToMany(mappedBy = "client")
	@JsonView(Views.ViewClientWithCommandes.class)
	private List<Commande> commandes = new ArrayList<>();
	
	//ICI
	@OneToMany(mappedBy = "client")
	@JsonView(Views.ViewClientWithArticlesFavoris.class)
	private List<ArticleFavori> ArticlesFavoris = new ArrayList<>();

	public Client() {
		super();
	}
	
	
	public Client(String email, String password, String nom, String prenom, Adresse adresse) {
		super(email, password, nom, prenom, adresse);

	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public List<ArticleFavori> getArticlesFavoris() {
		return ArticlesFavoris;
	}


	public void setArticlesFavoris(List<ArticleFavori> articlesFavoris) {
		ArticlesFavoris = articlesFavoris;
	}


	
}
