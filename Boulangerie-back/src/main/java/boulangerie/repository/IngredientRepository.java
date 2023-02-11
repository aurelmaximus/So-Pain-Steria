package boulangerie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boulangerie.model.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
	
	
}
