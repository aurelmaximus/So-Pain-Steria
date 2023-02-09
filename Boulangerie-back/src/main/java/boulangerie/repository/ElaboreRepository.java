package boulangerie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import boulangerie.model.Elabore;

//A voir si la query est bonne
public interface ElaboreRepository extends JpaRepository<Elabore,Integer>{
	

}
