package boulangerie.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import boulangerie.model.Elabore;


public interface ElaboreRepository extends JpaRepository<Elabore,Integer>{
	
	@Query("select distinct e from Elabore e left join fetch e.ligneIngredients where e.id=:id")
	Optional<Elabore> findByIdWithLigneIngredient(@Param("id") Integer id);
}
