package boulangerie.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import boulangerie.model.Basique;


public interface BasiqueRepository extends JpaRepository<Basique,Integer>{
	
	@Query("select b from Basique b left join fetch b.ligneIngredients where b.libelle=:libelle")
	List<Basique> findAllByLibelleWithLigneIngredients(String libelle);
	

}
