package repository;

import java.util.List;

import model.Produit;

public interface IDAOProduit extends IDAO<Produit,Integer>{

	public Produit findById(Integer id);
	public List<Produit> findAll();
	public void insert(Produit p);
	
	
}
