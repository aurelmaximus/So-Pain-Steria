package boulangerie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import boulangerie.model.Client;
import boulangerie.model.Commande;
import boulangerie.model.EtatCommande;


public interface LigneCommandeRepository extends JpaRepository<Commande,Integer> {

//	List<Commande> findAllByClient(Client client);
//	
//	@Query("select c from Commande c where  c.etatCommande = :et")
//	List<Commande> findAllByEtatCommande(@Param("et") EtatCommande etatC);
//	
//	@Query("select c from Commande c where c.client = :cl and c.etatCommande = :et")
//	List<Commande> findAllByClientAndEtatCommande(@Param("cl") Client client, @Param("et") EtatCommande etatC);
//	
}
