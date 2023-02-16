package boulangerie.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import boulangerie.model.LigneIngredient;


public interface LigneIngredientRepository extends JpaRepository<LigneIngredient,Integer> {
	
	
}
