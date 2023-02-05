package boulangerie.repository;

import java.util.List;

import boulangerie.model.Ingredient;


public interface IIngredientRepository extends IRepository<Ingredient,Integer> {
	
	List<Ingredient> findAllByLibelleProduit(String libelle);
	
}
