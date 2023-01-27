package repository;

import model.Ingredient;

public interface IDAOIngredient extends IRepository<Ingredient,Integer> {

	public Ingredient findById(Integer id);
	public void insert(Ingredient i);
	
}
