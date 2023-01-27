package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import boulangerie.context.Application;
import model.Commande;
import model.EtatCommande;
import repository.ICommandeRepository;

public class CommandeRepository implements ICommandeRepository {

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes = new ArrayList<>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Commande> query = em.createQuery("select f from Commande f", Commande.class);

			commandes = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return commandes;
	}

	@Override
	public Commande findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande save(Commande o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Commande o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commande> findAllByClient(Integer idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllByEtatCommande(EtatCommande etatC) {
		// TODO Auto-generated method stub
		return null;
	}

	



}