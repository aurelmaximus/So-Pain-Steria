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
import model.Commande;
import model.EtatCommande;
import repository.ICommandeRepository;

@Repository
public class CommandeRepository implements ICommandeRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Commande> findAll() {

		List<Commande> commandes = new ArrayList<>();

		TypedQuery<Commande> query = em.createQuery("select c from Commande c", Commande.class);
		commandes = query.getResultList();

		return commandes;
	}

	@Override
	public Commande findById(Integer id) {

		Commande commande = null;

		commande = em.find(Commande.class, id);

		return commande;
	}

	@Override
	@Transactional
	public Commande save(Commande commande) {

		commande = em.merge(commande);

		return commande;
	}

	@Override
	@Transactional
	public void deleteById(Integer numero) {

		TypedQuery<Commande> query = em.createQuery("delete from Commande c where c.numero = ?1", Commande.class);
		query.setParameter(1, numero);

		query.executeUpdate();

	}

	@Override
	@Transactional
	public void delete(Commande commande) {

		em.remove(em.merge(commande));

	}

	@Override
	public List<Commande> findAllByClient(Client client) {

		List<Commande> commandes = new ArrayList<>();

		TypedQuery<Commande> query = em.createQuery("select c from Commande c where c.client = :cl", Commande.class);

		query.setParameter("cl", client);
		commandes = query.getResultList();

		return commandes;
	}


	@Override
	public List<Commande> findAllByEtatCommande(EtatCommande etatC) {

		List<Commande> commandes = new ArrayList<>();

		TypedQuery<Commande> query = em.createQuery("select c from Commande c where  c.etatCommande = :et", Commande.class);

		query.setParameter("et", etatC);
		commandes = query.getResultList();

		return commandes;
	}

	@Override
	public List<Commande> findAllByClientAndEtatCommande(Client client, EtatCommande etatC) {

		List<Commande> commandes = new ArrayList<>();

		TypedQuery<Commande> query = em.createQuery("select c from Commande c where c.client = :cl and c.etatCommande = :et", Commande.class);
		query.setParameter("cl", client);
		query.setParameter("et", etatC);

		commandes = query.getResultList();

		return commandes;
	}





}