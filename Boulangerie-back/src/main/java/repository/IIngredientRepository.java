package repository;

import java.util.List;

import model.Ingredient;


public interface IIngredientRepository extends IRepository<Ingredient,Integer> {
	
	List<Ingredient> findAllByLibelleProduit(String libelle);
	
}
