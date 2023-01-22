package model;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Commande {

	private Integer numero;
	private boolean termine;
	protected LocalTime heure;
	private LocalTime minute;
	protected Client client;

	
	public Commande(Client client, LocalTime heure, LocalTime minute, boolean termine) {
		this.heure = heure;
		this.minute = minute;
		this.client = client;
	}

	
	public Commande(Integer numero, Client client, LocalTime heure, LocalTime minute, boolean termine) {
		this.numero = numero;
		this.heure = heure;
		this.minute = minute;
		this.client = client;
	}
	
	
	public static String saisieString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static boolean saisieBoolean(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextBoolean();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public boolean isTermine() {
		return termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
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


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Commande [numero=" + numero + ", termine=" + termine + ", heure=" + heure + ", minute=" + minute
				+ ", client=" + client + "]";
	}


}