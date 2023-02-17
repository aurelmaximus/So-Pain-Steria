package boulangerie.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import boulangerie.model.ArticleFavori;
import boulangerie.model.Client;


public interface ArticleFavorisRepository extends JpaRepository<ArticleFavori,Integer>{
	
	Optional<ArticleFavori> findByClient(Client client);

}
