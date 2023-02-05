package boulangerie.repository;

import java.util.List;

import boulangerie.model.Produit;


public interface IProduitRepository extends IRepository<Produit,Integer>{
	
	List<Produit> findAllByLibelleIngredient(String ingredient);
	
}
