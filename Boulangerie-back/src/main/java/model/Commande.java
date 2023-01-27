package model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Command")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	@Column(name = "Hour")
	private LocalTime heure;
	
	@Column(name = "Minute")
	private LocalTime minute;
	
	@Column(name = "Command_status)
	private EtatCommande etatcommande;
	
	
	private Client client;

	
	public Commande() {
		super();
	}


	public Commande(LocalTime heure, LocalTime minute, EtatCommande etatcommande) {
		super();
		this.heure = heure;
		this.minute = minute;
		this.etatcommande = etatcommande;
	}

	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public LocalTime getMinute() {
		return minute;
	}

	public void setMinute(LocalTime minute) {
		this.minute = minute;
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



}