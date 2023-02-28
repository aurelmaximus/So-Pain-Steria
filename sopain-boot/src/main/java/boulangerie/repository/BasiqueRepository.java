package boulangerie.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import boulangerie.model.Basique;
import boulangerie.model.Categorie;


public interface BasiqueRepository extends JpaRepository<Basique,Integer>{
	
	@Query("select distinct b from Basique b left join fetch b.ligneIngredients where b.id=:id")
	Optional<Basique> findByIdWithLigneIngredient(@Param("id") Integer id);
	
	@Query("select distinct b from Basique b where b.categorie=:cat")
	List<Basique> findByCategorie(@Param("cat")Categorie cat);

	@Query("select distinct b from Basique b where b.libelle=:label")
	Optional<Basique> findByLib(@Param("label")String libelle);

}
