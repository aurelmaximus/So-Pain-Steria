package repository;

import java.util.List;

import model.Commande;
import model.Compte;


public interface IDAOCommande extends IRepository<Compte,Integer> {

	public List<Commande> findAllByClient(Integer idClient);
	
	public List<Commande> findAllByEtatCommande(EtatCommande etatC);
	
}
