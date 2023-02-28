package boulangerie.model;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "account", uniqueConstraints = @UniqueConstraint(columnNames = { "last_name", "first_name" }))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo (use = JsonTypeInfo.Id.NAME, 
include = As.PROPERTY, property  = "type") @JsonSubTypes({

	@JsonSubTypes.Type(value = Client.class, name = "client"),
	@JsonSubTypes.Type(value = Employe.class, name = "employe")
})

public  class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@Version
	@JsonView(Views.ViewBase.class)
	private int version;
	
	@Column(name="email", length =50)
	@JsonView(Views.ViewBase.class)
	private String email;
	
	@Column(name="password", length =25)
	@JsonView(Views.ViewBase.class)
	private String password;
	
	@Column(name="last_name", length =25)
	@JsonView(Views.ViewBase.class)
	@NotBlank(message = "le nom est obligatoire")
	private String nom;
	
	@Column(name="first_name", length =25)
	@JsonView(Views.ViewBase.class)
	private String prenom;
	
	@Embedded
	@JsonView(Views.ViewBase.class)
	private Adresse adresse;


	//@JsonView(Views.ViewCompte.class)
	//private String type;
	
	
//	@JsonTypeInfo (use = JsonTypeInfo.Id.NAME, 
//	include = As.PROPERTY, property = "type") @JsonSubTypes({
//
//		@JsonSubTypes.Type(value = Client.class, name = "square"),
//		@JsonSubTypes.Type(value = Employe.class, name = "circle")
//	})

	
	
	public Compte() {
		super();
	}


	public Compte(String email, String password, String nom, String prenom, Adresse adresse) {
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	
}
