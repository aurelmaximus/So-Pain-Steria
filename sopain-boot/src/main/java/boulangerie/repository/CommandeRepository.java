package boulangerie.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import boulangerie.model.Commande;




public interface CommandeRepository extends JpaRepository<Commande,Integer> {

@Query("select distinct c from Commande c left join fetch c.ligneCommandes where c.id=:id")
Optional<Commande> findByIdWithLigneCommande(@Param("id") Integer id);



}


