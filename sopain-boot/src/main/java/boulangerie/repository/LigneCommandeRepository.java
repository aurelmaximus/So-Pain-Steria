package boulangerie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import boulangerie.model.Commande;
import boulangerie.model.LigneCommande;


public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Integer> {

//	List<LigneCommande> findAllByCommande(Commande commande);
	
//	@Query("select c from Commande c where  c.etatCommande = :et")
//	List<Commande> findAllByEtatCommande(@Param("et") EtatCommande etatC);
//	
//	@Query("select c from Commande c where c.client = :cl and c.etatCommande = :et")
//	List<Commande> findAllByClientAndEtatCommande(@Param("cl") Client client, @Param("et") EtatCommande etatC);
//	
}
