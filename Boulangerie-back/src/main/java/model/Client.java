package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

//Pret pour Mapping

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("Customer")
public class Client extends Compte {

	
	@Column(name="Points")
	private int points;
	
	@OneToMany(mappedBy = "Customer")
	private List<Commande> commandes = new ArrayList<>();
	
	@OneToMany(mappedBy = "Customer")
	private List<ArticleFavoris> ArticlesFavoris = new ArrayList<>();

	public Client() {
		super();
	}
	
	
	public Client(String login, String password, String nom, String prenom, Adresse adresse) {
		super(login, password, nom, prenom, adresse);

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


	public List<ArticleFavoris> getArticlesFavoris() {
		return ArticlesFavoris;
	}


	public void setArticlesFavoris(List<ArticleFavoris> articlesFavoris) {
		ArticlesFavoris = articlesFavoris;
	}


	
}
