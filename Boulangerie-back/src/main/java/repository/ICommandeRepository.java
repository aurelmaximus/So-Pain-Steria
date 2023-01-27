package repository;

import java.util.List;

import model.Client;
import model.Commande;
import model.EtatCommande;


public interface ICommandeRepository extends IRepository<Commande,Integer> {

	List<Commande> findAllByClient(Client client);
	
	List<Commande> findAllByEtatCommande(EtatCommande etatC);
	
}
