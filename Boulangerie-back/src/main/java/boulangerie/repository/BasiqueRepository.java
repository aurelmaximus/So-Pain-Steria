package boulangerie.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import boulangerie.model.Ingredient;
import boulangerie.model.Produit;


public interface BasiqueRepository extends JpaRepository<Produit,Integer>{
	
	@Query("select distinct p from Produit p join fetch p.lignesIngredients l where l.ingredient.libelle=:libelle")
	List<Produit> findAllByLibelleIngredient(@Param("libelle")Ingredient libelle);
	
}
