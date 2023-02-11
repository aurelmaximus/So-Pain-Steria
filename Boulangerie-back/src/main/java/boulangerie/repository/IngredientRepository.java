package boulangerie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import boulangerie.model.Ingredient;
import boulangerie.model.Produit;


public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
	
	List<Ingredient> findAllByLibelleProduit(String produit);
	
	List <Ingredient> findByLignesingredientProduitLibelle (String libelleProduit);
	
}
