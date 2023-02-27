package boulangerie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import boulangerie.model.Employe;

public interface EmployeRepository  extends JpaRepository<Employe,Integer> {
	
	Optional<Employe> findByEmail(String email);

	@Query("select c from Employe c where c.email = ?1 and c.password = ?2")
	Optional<Employe> findByEmailAndPassword(String email, String password);

}
