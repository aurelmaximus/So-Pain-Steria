package boulangerie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import boulangerie.model.Compte;


public interface CompteRepository extends JpaRepository<Compte, Integer> {

	Optional<Compte> findByEmail(String email);

	@Query("select c from Compte c where c.email = ?1 and c.password = ?2")
	Optional<Compte> findByEmailAndPassword(String email, String password);



}
