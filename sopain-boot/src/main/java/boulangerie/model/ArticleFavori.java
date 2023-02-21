package boulangerie.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name ="favorite_articles")
public class ArticleFavori {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;

	@Version
	@JsonView(Views.ViewBase.class)
	private int version;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonView(Views.ViewArticleFavoris.class)
	private Client client;

	
	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	@JsonView(Views.ViewArticleFavoris.class)
	private Produit produit;

	public ArticleFavori() {
		super();
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Produit getProduit() {
		return produit;
	}



	public void setProduit(Produit produit) {
		this.produit = produit;
	}



	public ArticleFavori(Client client, Produit produit) {
		super();
		this.client = client;
		this.produit = produit;
	}

	public Client getClient() {
		return client;
	}

	
	public void setClient(Client client) {
		this.client = client;
	}

	
	public Integer getVersion() {
		return version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}



	@Override
	public String toString() {
		return "ArticleFavoris [produit=" + produit + "]";
	}
	
	

}
