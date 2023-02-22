package boulangerie.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import boulangerie.model.Basique;


public interface BasiqueRepository extends JpaRepository<Basique,Integer>{
	
	@Query("select distinct b from Basique b left join fetch b.ligneIngredients where b.id=:id")
	Optional<Basique> findByIdWithLigneIngredient(@Param("id") Integer id);

}
