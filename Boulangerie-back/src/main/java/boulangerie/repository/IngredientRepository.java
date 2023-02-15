package boulangerie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import boulangerie.model.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
	
	@Query("select i from Ingredient i left join fetch i.ligneIngredients where i.libelle=:libelle")
	List<Ingredient> findAllByLibelleWithLigneIngredients( @Param("libelle")String libelle);
}
