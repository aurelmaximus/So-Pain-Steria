package boulangerie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import boulangerie.model.Commande;
import boulangerie.model.LigneCommande;


public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Integer> {

	@Query("select lc from LigneCommande lc left join fetch lc.commande c where c.numero=?1")
	List<LigneCommande> findAllByCommandeId(Integer numCom);
	
//	@Query("select c from Commande c where  c.etatCommande = :et")
//	List<Commande> findAllByEtatCommande(@Param("et") EtatCommande etatC);
//	
//	@Query("select c from Commande c where c.client = :cl and c.etatCommande = :et")
//	List<Commande> findAllByClientAndEtatCommande(@Param("cl") Client client, @Param("et") EtatCommande etatC);
//	
}
