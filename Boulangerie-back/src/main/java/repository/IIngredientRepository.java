package repository;

import model.Ingredient;

<<<<<<< Updated upstream
public interface IDAOIngredient extends IRepository<Ingredient,Integer> {
=======
public interface IIngredientRepository extends IDAO<Ingredient,Integer> {
>>>>>>> Stashed changes

	public Ingredient findById(Integer id);
	public void insert(Ingredient i);
	
}
