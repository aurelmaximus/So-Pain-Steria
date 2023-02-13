package boulangerie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import boulangerie.model.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
	
//	@Query("select i ingredient i left join fetch i.lignesIngredient li where li.produit.libelle=:libelleProduit")
//	List<Ingredient> findByLignesingredientProduitLibelle (String libelleProduit);
	
	@Query("select i from Ingredient i left join fetch i.ligneIngredients where i.libelle=:libelle")
	List<Ingredient> findAllByLibelleWithLigneIngredients(String libelle);
}
