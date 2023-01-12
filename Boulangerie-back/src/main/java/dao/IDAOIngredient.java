package dao;

import model.Ingredient;

public interface IDAOIngredient extends IDAO<Ingredient,Integer> {

	public Ingredient findById(Integer id);
	public void insert(Ingredient i);
	
}
