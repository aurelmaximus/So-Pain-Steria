package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "command")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	@Version
	private Integer version;
	
	@Column(name = "arrived_date")
	private LocalDate dateArrivee;
	
	@Column(name = "arrived_hour")
	private LocalTime heureArrive;
	
	@Column(name="on_site")
	private boolean surPlace;
	
	
	@Column(name = "command_status")
	private EtatCommande etatcommande;
	
	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> LigneCommandes = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Client client;

	
	public Commande() {
		super();
	}


	public Commande(LocalDate dateArrivee, LocalTime heureArrive, EtatCommande etatcommande,
			boolean surPlace) {
		super();
		this.dateArrivee = dateArrivee;
		this.heureArrive = heureArrive;
		this.etatcommande = etatcommande;
		this.surPlace = surPlace;
	}


	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public EtatCommande getEtatcommande() {
		return etatcommande;
	}


	public void setEtatcommande(EtatCommande etatcommande) {
		this.etatcommande = etatcommande;
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


	public LocalDate getDateArrivee() {
		return dateArrivee;
	}


	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}


	public LocalTime getHeureArrive() {
		return heureArrive;
	}


	public void setHeureArrive(LocalTime heureArrive) {
		this.heureArrive = heureArrive;
	}


	public boolean isSurPlace() {
		return surPlace;
	}


	public void setSurPlace(boolean surPlace) {
		this.surPlace = surPlace;
	}



}