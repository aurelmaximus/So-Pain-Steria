package test;

import java.time.LocalDate;
import java.time.LocalTime;

import boulangerie.context.Application;
import model.Adresse;
import model.Client;
import model.Commande;
import model.Compte;
import model.Elabore;
import model.EtatCommande;
import model.Ingredient;
import model.Produit;
import repository.ICommandeRepository;
import repository.ICompteRepository;
import repository.IIngredientRepository;
import repository.IProduitRepository;

public class Test {

	public static void main(String[] args) {


		ICommandeRepository commandeRepo = Application.getInstance().getCommandeRepo();
		IIngredientRepository ingredientRepo = Application.getInstance().getIngredientRepo();		
		IProduitRepository produitRepo = Application.getInstance().getProduitRepo();
		ICompteRepository compteRepo = Application.getInstance().getCompteRepo();

		
		Compte cl1 = new Client("cl1@oui.fr", "secret", "Moi", "Moche", new Adresse("12", "Rue des Papayes", "Ouiouiville", "112234") );
		cl1 = compteRepo.save(cl1);
		
		Ingredient creme = new Ingredient("Crème fraîche", true);
		creme = ingredientRepo.save(creme);
		
		Ingredient feuille_or = new Ingredient("Feuille d'or", false);
		feuille_or = ingredientRepo.save(feuille_or);
		
		Produit gateauRepo = new Elabore(25, "Gâteau Repo", 4);
		gateauRepo = produitRepo.save(gateauRepo);
		
		Commande cmd = new Commande(LocalDate.parse("2023-02-03"), LocalTime.parse("13:00"), EtatCommande.EnCours, false);
		cmd.setClient((Client) cl1);
		cmd = commandeRepo.save(cmd);
		
		System.out.println("client:"+cl1);
		System.out.println("crem:"+creme);
		System.out.println("feuille  d'or:"+feuille_or);
		
		System.out.println("Produit:"+cl1);
		
		System.out.println(cmd);
		
		
	}

}
