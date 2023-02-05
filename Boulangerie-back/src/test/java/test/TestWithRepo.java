package test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import boulangerie.model.Adresse;
import boulangerie.model.Client;
import boulangerie.model.Commande;
import boulangerie.model.Elabore;
import boulangerie.model.EtatCommande;
import boulangerie.model.Ingredient;
import boulangerie.model.LigneIngredient;
import boulangerie.repository.ICommandeRepository;
import boulangerie.repository.ICompteRepository;
import boulangerie.repository.IIngredientRepository;
import boulangerie.repository.ILigneIngredientRepository;
import boulangerie.repository.IProduitRepository;

public class TestWithRepo {
	
	@Autowired
	private IProduitRepository produitRepo;
	@Autowired
	private ICommandeRepository commandeRepo;
	@Autowired
	private ILigneIngredientRepository ligneIngredientRepo;
	@Autowired
	private ICompteRepository compteRepo;
	@Autowired
	private IIngredientRepository ingredientRepo;
	

	public void run(String[] args) {


		//ICommandeRepository commandeRepo = Application.getInstance().getCommandeRepo();
		//IIngredientRepository ingredientRepo = Application.getInstance().getIngredientRepo();
		//ILigneIngredientRepository ligneIngredientRepo = Application.getInstance().getLigneCommandeRepo();
		//IProduitRepository produitRepo = Application.getInstance().getProduitRepo();
		//ICompteRepository compteRepo = Application.getInstance().getCompteRepo();

		
		Client cl1 = new Client("cl1@oui.fr", "secret", "Moi", "Moche", new Adresse("12", "Rue des Papayes", "Ouiouiville", "112234") );
		cl1 = (Client) compteRepo.save(cl1);
		
		Ingredient creme = new Ingredient("Crème fraîche", true);
		creme = ingredientRepo.save(creme);
		
		Ingredient feuille_or = new Ingredient("Feuille d'or", false);
		feuille_or = ingredientRepo.save(feuille_or);
		
		BigDecimal bd = new BigDecimal("25.00");
		Elabore gateauRepo = new Elabore(bd, "Gâteau Repo", 4);
		gateauRepo = (Elabore) produitRepo.save(gateauRepo);
		
		LigneIngredient gateauRepoCreme = new LigneIngredient();
		gateauRepoCreme.setProduit(gateauRepo);
		gateauRepoCreme.setIngredient(creme);
		gateauRepoCreme = ligneIngredientRepo.save(gateauRepoCreme);
		
		LigneIngredient gateauRepoFeuilleOr = new LigneIngredient();
		gateauRepoFeuilleOr.setProduit(gateauRepo);
		gateauRepoFeuilleOr.setIngredient(feuille_or);
		gateauRepoFeuilleOr = ligneIngredientRepo.save(gateauRepoFeuilleOr);
		
		Commande cmd = new Commande(LocalDate.parse("2023-02-03"), LocalTime.parse("13:00"), EtatCommande.EnCours, false);
		cmd.setClient(cl1);
		cmd = commandeRepo.save(cmd);
		
		System.out.println(gateauRepo);
		List<LigneIngredient> ingredientsGateauRepo = ligneIngredientRepo.findAllByLibelleProduit(gateauRepo.getLibelle());
		System.out.println("Composition de " + gateauRepo.getLibelle() + " : " + ingredientsGateauRepo);
		
		List<Ingredient> ingredientsGateauRepo2 = ingredientRepo.findAllByLibelleProduit(gateauRepo.getLibelle());
		System.out.println("Composition de " + gateauRepo.getLibelle() + " : " + ingredientsGateauRepo2);
		
		System.out.println("client:"+cl1);
		System.out.println("crem:"+creme);
		System.out.println("feuille  d'or:"+feuille_or);
		
		System.out.println("Produit:"+gateauRepo);
		
		System.out.println(cmd);
		
		
	}

}
