package boulangerie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boulangerie.model.Employe;

public interface EmployeRepository  extends JpaRepository<Employe,Integer> {

}
