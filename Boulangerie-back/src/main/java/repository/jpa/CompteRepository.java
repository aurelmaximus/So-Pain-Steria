package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import boulangerie.context.Application;
import model.Client;
import model.Compte;
import model.Employe;
import repository.ICompteRepository;

@Repository
public class CompteRepository implements ICompteRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Compte> findAll() {

		List<Compte> comptes = new ArrayList<>();

		TypedQuery<Compte> query = em.createQuery("select com from Compte com", Compte.class);
		comptes = query.getResultList();

		return comptes;
	}

	@Override
	public Compte findById(Integer id) {

		Compte compte = null;

		compte = em.find(Compte.class, id);

		return compte;
	}

	@Override
	@Transactional
	public Compte save(Compte compte) {

		compte = em.merge(compte);

		return compte;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {

		TypedQuery<Compte> query = em.createQuery("delete from Compte com where com.id = ?1", Compte.class);
		query.setParameter("id", id);
		query.executeUpdate();

	}

	@Override
	@Transactional
	public void delete(Compte compte) {

		em.remove(em.merge(compte));

	}


	@Override
	public Compte findByEmailAndPassword(String email, String password) {

		Compte compte = null;

		TypedQuery<Compte> query = em.createQuery("select com from Compte com where com.email= :pass and com.password= :pass", Compte.class);
		query.setParameter("pass", email);
		query.setParameter("pass", password);
		compte = query.getSingleResult();

		return compte;
	}

	@Override
	public List<Employe> findAllEmploye() {

		List<Employe> employes = new ArrayList<>();

		TypedQuery<Employe> query = em.createQuery("select emp from Employe emp", Employe.class);
		employes = query.getResultList();

		return employes;
	}

	@Override
	public List<Client> findAllClient() {
		List<Client> clients = new ArrayList<>();

		TypedQuery<Client> query = em.createQuery("select cl from Client cl", Client.class);
		clients = query.getResultList();

		return clients;
	}

	@Override
	public Employe findEmployeById(Integer id) {
		Employe employe = null;

		TypedQuery<Employe> query = em.createQuery("select emp from Employe emp where emp.id = :id", Employe.class);

		query.setParameter("id", id);
		employe = query.getSingleResult();

		return employe;
	}

	@Override
	public Client findClientById(Integer id) {
		Client client = null;

		TypedQuery<Client> query = em.createQuery("select cl from Client cl where cl.id = :id", Client.class);

		query.setParameter("id", id);
		client = query.getSingleResult();

		return client;
	}

	@Override
	public Client findClientByIdWithArticlesFavoris(Integer id) {

		Client client = null;

		TypedQuery<Client> query = em.createQuery("select distinct cl from Client cl join fetch cl.articlesFavoris where cl.id = :id", Client.class);

		query.setParameter("id", id);
		client = query.getSingleResult();


		return client;
	}


}
