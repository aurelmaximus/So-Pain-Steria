package model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name ="Favorite_Articles")
public class ArticleFavoris {
	

	@Version
	private Integer version;

	@ManyToOne
	@JoinColumn(name = "Customer_id")
	private Client client;

	
	@OneToOne
	@JoinColumn(name = "Product_id")
	private Produit produit;

	public ArticleFavoris() {
		super();
	}
	

	public ArticleFavoris(Client client) {
		super();
		this.client = client;
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
	

}
