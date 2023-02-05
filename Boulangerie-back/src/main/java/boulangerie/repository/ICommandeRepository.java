package boulangerie.repository;

import java.util.List;

import boulangerie.model.Client;
import boulangerie.model.Commande;
import boulangerie.model.EtatCommande;


public interface ICommandeRepository extends IRepository<Commande,Integer> {

	List<Commande> findAllByClient(Client client);
	
	List<Commande> findAllByEtatCommande(EtatCommande etatC);
	
	List<Commande> findAllByClientAndEtatCommande(Client client, EtatCommande etatC);
	
}
