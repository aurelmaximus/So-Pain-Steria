package model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


public class SansCompte {

	@Entity
	@Table(name = "Withtout_Account")
	public abstract class Compte {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Version
		private int version;
		
		@Column(name="Email")
		private String email;
		
		
		@Column(name="Last_name")
		private String nom;
		
		@Column(name="First_name")
		private String prenom;
		
		@OneToOne
		@JoinColumn(name = "Command_numero")
		private Commande commande;

		
		public Compte() {
			super();
		}


		public Compte(String email, String nom, String prenom,Commande commande) {
			super();
			this.email = email;
			this.nom = nom;
			this.prenom = prenom;
			this.commande =commande;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public int getVersion() {
			return version;
		}


		public void setVersion(int version) {
			this.version = version;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
		public Commande getCommande() {
			return commande;
		}

		public void setCommande(Commande commande) {
			this.commande = commande;
		}
	
		
	}	
		
	
}
