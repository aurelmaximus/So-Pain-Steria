package repository;

import java.util.List;

import model.Produit;


public interface IProduitRepository extends IRepository<Produit,Integer>{
	
	List<Produit> findAllByLibelleIngredient(String ingredient);
	
}
