package boulangerie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boulangerie.model.Client;

public interface ClientRepository  extends JpaRepository<Client,Integer> {

}
