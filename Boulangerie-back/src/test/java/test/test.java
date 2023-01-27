package test;

import boulangerie.context.Application;
import repository.IIngredientRepository;
import repository.IProduitRepository;

public class test {

	public static void main(String[] args) {
		
		//ICommandeRepository commandeRepo = Application.getInstance()
		//ICompteRepository compteRepo = Application.getInstance()
		
		IProduitRepository produitRepo = Application.getInstance().getProduitRepo();
		IIngredientRepository ingredientRepo = Application.getInstance().getIngredientRepo();
		

	
		
	}

}
