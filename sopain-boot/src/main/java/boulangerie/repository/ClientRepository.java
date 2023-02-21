package boulangerie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import boulangerie.model.Client;


public interface ClientRepository  extends JpaRepository<Client,Integer> {

	@Query("select distinct c from Client c left join fetch c.commandes where c.id=:id")
	Optional<Client> findByIdWithCommandes(@Param("id") Integer id);
	
	@Query("select distinct c from Client c left join fetch c.ArticlesFavoris where c.id=:id")
	Optional<Client> findByIdWitharticlesfavori(@Param("id") Integer id);
}
