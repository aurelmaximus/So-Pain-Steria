package boulangerie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import boulangerie.model.Basique;


//A voir si la query est bonne
public interface BasiqueRepository extends JpaRepository<Basique,Integer>{
	

}
