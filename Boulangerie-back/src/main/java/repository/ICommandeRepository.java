package repository;

import java.util.List;

import model.Commande;
import model.Compte;
import model.EtatCommande;


public interface ICommandeRepository extends IRepository<Commande,Integer> {

	public List<Commande> findAllByClient(Integer idClient);
	
	public List<Commande> findAllByEtatCommande(EtatCommande etatC);
	
}
