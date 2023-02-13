package boulangerie.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import boulangerie.model.Elabore;

public interface ElaboreRepository extends JpaRepository<Elabore,Integer>{
	
	@Query("select  e from Elabore e left join fetch e.ligneIngredients where e.libelle=:libelle")
	List<Elabore> findAllByLibelleWithLigneIngredients(String libelle);
	

}
