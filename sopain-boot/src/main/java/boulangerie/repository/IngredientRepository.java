package boulangerie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import boulangerie.model.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
		
	@Query("select i from Ingredient i left join fetch i.lignesIngredient where i.libelle=:libelle")
	List<Ingredient> findAllByLibelleWithLigneIngredients(String libelle);
	

	@Query("select i from Ingredient i left join fetch i.lignesIngredient li where li.produit.libelle=:libelleProduit")
	List<Ingredient> findByLignesingredientProduitLibelle (@Param("libelleProduit")String libelleProduit);
	
	@Query("select distinct i from Ingredient i left join fetch i.lignesIngredient where i.id=:id")
	Optional<Ingredient> findByIdWithLigneIngredients(@Param("id") Integer id);
	
}
