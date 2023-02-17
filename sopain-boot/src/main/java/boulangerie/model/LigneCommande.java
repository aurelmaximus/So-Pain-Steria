package boulangerie.model;

import java.math.BigDecimal;

import javax.persistence.Column;
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
@Table(name = "command_line")
public class LigneCommande{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@Version
	@JsonView(Views.ViewBase.class)
	private int version;
	
	@Column(name = "quantity" , length = 4)
	@JsonView(Views.ViewBase.class)
	private int qte;
	
	@Column(name = "total" , precision=5, scale=2)
	@JsonView(Views.ViewBase.class)
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name = "command_id")
	@JsonView(Views.ViewBase.class)
	private Commande commande;
	
	@OneToOne
	@JoinColumn(name = "product_label", referencedColumnName = "label")
	@JsonView(Views.ViewBase.class)
	private Produit produit;

	
	public LigneCommande() {
		super();
	}
	

	public LigneCommande(int qte, BigDecimal total) {
		super();
		this.qte = qte;
		this.total = total;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", version=" + version + ", qte=" + qte + ", total=" + total + ", commande="
				+ commande + ", produit=" + produit + "]";
	}

	

	
}