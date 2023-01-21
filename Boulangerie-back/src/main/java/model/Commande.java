package model;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Commande {

	private Integer numero;
	private boolean termine;
	private double prixTTC;
	protected LocalTime heure;
	private LocalTime minute;

	protected static Client client;

	public Commande(Integer numero, Client client, LocalTime heure, LocalTime minute, boolean termine) {
		this.numero = numero;
		this.prixTTC = prixTTC;
		this.heure = heure;
		this.minute = minute;
		this.client = client;
	}
	
	public Commande(Client client, LocalTime heure, LocalTime minute, boolean termine) {
		this.prixTTC = prixTTC;
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

	public double getPrixTTC() {
		return prixTTC;
	}

	public void setPrixTTC(double prixTTC) {
		this.prixTTC = prixTTC;
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

	public static Client getClient() {
		return client;
	}

	public static void setClient(Client client) {
		Commande.client = client;
	}

	public static void Commande() {

		Map<Boissons, Integer> panier = new HashMap();
		Map<Pain, Integer> panier2 = new HashMap();
		Map<Viennoiseries, Integer> panier3 = new HashMap();
		Map<Gateaux, Integer> panier4 = new HashMap();

		// Boissons
		String boissons = saisieString("Voulez-vous commander une boisson ? Oui/Non");
		while (boissons.equals("Oui")) {
			for (Boissons b : Boissons.values()) {
				System.out.println(b + " - " + b.getPrix() + " euros");
			}
			String choixBoisson = saisieString("Veuillez saisir votre choix");
			Boissons Boisson = Boissons.valueOf(choixBoisson);
			int qte = saisieInt("Veuillez saisir votre quantite de " + Boisson);

			if (panier.containsKey(Boisson)) {
				panier.replace(Boisson, panier.get(Boisson) + qte);
			} else {
				panier.put(Boisson, qte);
			}

			boissons = saisieString("Commander une autre boisson ?");
		}

		// Pain
		String pain = saisieString("Voulez-vous commander du pain ? Oui/Non");
		while (pain.equals("Oui")) {
			for (Pain p : Pain.values()) {
				System.out.println(p + " - " + p.getPrix() + " euros");
			}
			String choixPain = saisieString("Veuillez saisir votre choix");
			Pain Pain1 = Pain.valueOf(choixPain);
			int qte = saisieInt("Veuillez saisir votre quantite de" + Pain1);

			if (panier2.containsKey(Pain1)) {
				panier2.replace(Pain1, panier2.get(Pain1) + qte);
			} else {
				panier2.put(Pain1, qte);
			}

			pain = saisieString("Commander un autre pain ?");
		}

		// Vienoisseries
		String viennoiseries = saisieString("Voulez-vous commander une Viennoiseries ? Oui/Non");
		while (viennoiseries.equals("Oui")) {
			for (Viennoiseries v : Viennoiseries.values()) {
				System.out.println(v + " - " + v.getPrix() + " euros");
			}
			String choixViennoiseries = saisieString("Veuillez saisir votre choix");
			Viennoiseries Viennoiseries1 = Viennoiseries.valueOf(choixViennoiseries);
			int qte = saisieInt("Veuillez saisir votre quantite de " + Viennoiseries1);

			if (panier3.containsKey(Viennoiseries1)) {
				panier3.replace(Viennoiseries1, panier3.get(Viennoiseries1) + qte);
			} else {
				panier3.put(Viennoiseries1, qte);
			}

			viennoiseries = saisieString("Commander une autre viennoiseries ?");
		}

		// Gateaux
		String gateaux = saisieString("Voulez-vous commander un Gateaux ? Oui/Non");
		while (gateaux.equals("Oui")) {
			for (Gateaux g : Gateaux.values()) {
				System.out.println(g + " - " + g.getPrix() + " euros");
			}
			String choixGateaux = saisieString("Veuillez saisir votre choix");
			Gateaux Gateaux1 = Gateaux.valueOf(choixGateaux);
			int qte = saisieInt("Veuillez saisir votre quantite de " + Gateaux1);

			if (panier4.containsKey(Gateaux1)) {
				panier4.replace(Gateaux1, panier4.get(Gateaux1) + qte);
			} else {
				panier4.put(Gateaux1, qte);
			}

			gateaux = saisieString("Commander un autre Gateau ?");
		}

		System.out.println("Vous avez saisie votre commande avec succes");

		System.out.println("\n");

		System.out.println("Récapitulatif de votre commande :");

		System.out.println("Client : \t\t" + client);

		System.out.println("\n---------------- Detail de votre commande ----------------");
		System.out.println("\n");

		double prixTTC = 0;

		// Boisson
		for (Boissons b : panier.keySet()) {
			int qte = panier.get(b);
			System.out.println(b + " - " + b.getPrix() + " euros (* " + qte + " )");
			prixTTC += b.getPrix() * qte;
		}

		// Pain
		for (Pain p : panier2.keySet()) {
			int qte = panier2.get(p);
			System.out.println(p + " - " + p.getPrix() + " euros (* " + qte + " )");
			prixTTC += p.getPrix() * qte;
		}

		// Viennoiseries
		for (Viennoiseries v : panier3.keySet()) {
			int qte = panier3.get(v);
			System.out.println(v + " - " + v.getPrix() + " euros (* " + qte + " )");
			prixTTC += v.getPrix() * qte;
		}

		// Gateaux
		for (Gateaux g : panier4.keySet()) {
			int qte = panier4.get(g);
			System.out.println(g + " - " + g.getPrix() + " euros (* " + qte + " )");
			prixTTC += g.getPrix() * qte;
		}

		System.out.println("\n--------------------- Total à Payer ---------------------");

		System.out.println("\n\nTOTAL TTC : \t\t" + prixTTC + "€");
	}

}
