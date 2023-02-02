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

@Entity
@Table(name = "withtout_account")
public class SansCompte {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Version
		private Integer version;
		
		@Column(name="email", length =50)
		private String email;
		
		
		@Column(name="last_name", length =25)
		private String nom;
		
		@Column(name="first_name", length =25)
		private String prenom;
		
		@OneToOne
		@JoinColumn(name = "command_numero")
		private Commande commande;

		

		public SansCompte() {
			super();
		}

		
		

		public SansCompte(String email, String nom, String prenom) {
			super();
			this.email = email;
			this.nom = nom;
			this.prenom = prenom;
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
		

