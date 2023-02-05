package boulangerie.repository;

import java.util.List;

import boulangerie.model.Ingredient;
import boulangerie.model.LigneIngredient;


public interface ILigneIngredientRepository extends IRepository<LigneIngredient,Integer> {
	
	List<LigneIngredient> findAllByLibelleProduit(String libelle);
	
}
