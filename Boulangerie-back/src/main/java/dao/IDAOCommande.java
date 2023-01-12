package dao;

import java.util.List;

import model.Commande;
import model.Compte;


public interface IDAOCommande extends IDAO<Compte,Integer> {

	public List<Commande> findAllByClient(Integer idClient);
	
}
