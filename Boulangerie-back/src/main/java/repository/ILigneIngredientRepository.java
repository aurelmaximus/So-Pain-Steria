package repository;

import java.util.List;

import model.Ingredient;
import model.LigneIngredient;


public interface ILigneIngredientRepository extends IRepository<LigneIngredient,Integer> {
	
	List<Ingredient> findAllByLibelleProduit(String libelle);
	
}
