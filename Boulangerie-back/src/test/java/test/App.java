package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.DAOCommande;
import dao.DAOCompte;
import dao.DAOIngredient;
import dao.DAOProduit;
import model.Boissons;
import model.Client;
import model.Commande;
import model.Compte;
import model.Employe;
import model.Gateaux;
import model.Ingredient;
import model.Pain;
import model.Produit;
import model.Viennoiseries;

public class App {

	static DAOCompte daoCpt = new DAOCompte();
	static DAOCommande daoCmd = new DAOCommande();
	static DAOIngredient daoI = new DAOIngredient();
	static DAOProduit daoP = new DAOProduit();
	static LinkedList<Commande> commandes = new LinkedList();
	static List<Produit> stocks = new ArrayList();
	static Compte connected;

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

	public static void menuPrincipal() {
		System.out.println("\nWelcome to Boulangerie");
		System.out.println("1- Se connecter");
		System.out.println("2- Fermer");

		int choix = saisieInt("Choisir un menu :\n");

		switch (choix) {
		case 1:
			seConnecter();
			break;
		case 2:
			System.exit(0);
			break;
		}
		menuPrincipal();
	}

	public static void seConnecter() {

		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");

		connected = daoCpt.seConnecter(login, password);

		if (connected instanceof Employe) {

			System.out.println("Connecté en tant que " + connected);
			menuEmploye();
		} else if (connected instanceof Client) {
			System.out.println("Connecté en tant que " + connected);
			menuClient();
		}

		else {
			System.out.println("Identifiants invalides");
		}

	}

	public static void menuEmploye() {
		System.out.println("\nMenu Employe :");
		System.out.println("1- Gérer les commandes");
		System.out.println("2- L'état de stock des produits finis");
		System.out.println("3- Gérer les clients");
		System.out.println("4- Se deconnecter");

		int choix = saisieInt("Choisir menu");

		switch (choix) {
		case 1:
			menuGererCommandes();
			break;
		case 2:
			etatStockPF();
			break;
		case 3:
			menuGererClients();
			break;
		case 4:
			menuPrincipal();
			break;
		}

		menuEmploye();

	}

	public static void menuGererCommandes() {
		System.out.println("\nMenu Gerer les commandes :");
		System.out.println("1- Liste de commandes en cours");
		System.out.println("2- Historique des commandes");
		System.out.println("3- Revenir au Menu Employe ");

		int choix = saisieInt("Choisir menu");

		switch (choix) {
		case 1:
			listeCommandes();
			break;
		case 2:
			historiqueCommandes();
			break;
		case 3:
			menuEmploye();
			break;

		}

		menuGererCommandes();

	}

	public static void etatStockPF() {

		System.out.println("----- STOCKS -----");
		stocks = daoP.findAll();

		if (stocks.isEmpty()) {
			System.out.println("Les stocks sont vides !?");
		}

		else {
			for (Produit p : stocks) {
				System.out.println(p);
			}
		}

	}

	public static void listeCommandes() {

		if (commandes.isEmpty()) {

			System.out.println("Pas de commande en cours");
		}

		else {
			for (Commande c : commandes) {
				System.out.println(c);
			}
		}
	}

	public static void historiqueCommandes() {

		listeClients();

		Integer id = saisieInt("\nSaisir l'id du client pour afficher son historique:");
		Client client = (Client) daoCpt.findById(id);

		List<Commande> cmdClient = daoCmd.findByIdClient(id);

		if (cmdClient.isEmpty()) {

			System.out.println(client.getNom() + " n'a jamais passé de commande :'(");
		}

		else {
			for (Commande c : cmdClient) {
				System.out.println(c);
			}
		}
	}

	public static void menuGererClients() {
		System.out.println("\nMenu Gerer les clients :");
		System.out.println("1- Liste de clients");
		System.out.println("2- Supprimer un client ");

		int choix = saisieInt("Choisir menu");

		switch (choix) {
		case 1:
			listeClients();
			break;
		case 2:
			supprimerClient();
			break;

		}

		menuGererClients();

	}

	public static void listeClients() {

		List<Compte> clients = daoCpt.findAll();
		if (clients.isEmpty()) {
			System.out.println("Pas de clients");
		} else {
			for (Compte c : clients)
				System.out.println(c);
		}
	}

	public static void supprimerClient() {
		
		listeClients();
		Integer id = saisieInt("\nSaisir l'id du client à supprimer");
		
		

	}

	public static void menuClient() {

		System.out.println("\nMenu Client :");
		System.out.println("1- Voir produits");
		System.out.println("2- Passer une commande");
		System.out.println("3- Voir mon panier ");
		System.out.println("4- Mon profil ");
		System.out.println("5- Se deconnecter");

		int choix = saisieInt("Choisir menu");

		switch (choix) {
		case 1:
			afficherProduits();
			break;
		case 2:
			commander();
			break;
		case 3:
			afficherPanier();
			break;
		case 4:
			profilClient();
			break;
		case 5:
			menuPrincipal();
			break;
		}
		menuClient();
	}

	public static void afficherProduits() {

	}

	public static void commander() {

		
		
		
	}

	
	public static void afficherPanier() {

		
		
		
	}

	
	public static void profilClient() {

		System.out.println("\nMon profil :");
		System.out.println("1- Historique de commandes");
		System.out.println("2- Modifier mon adresse");
		System.out.println("3- Retour");

		int choix = saisieInt("Choisir menu");

		switch (choix) {
		case 1:
			historiqueCommandesClient();
			break;
		case 2:
			modifierAdresseClient();
			break;
		case 3:
			menuClient();
			break;
		}
		profilClient();
	}

	public static void historiqueCommandesClient() {

	}

	public static void modifierAdresseClient() {

	}

	public static void main(String[] args) {

	}
}
