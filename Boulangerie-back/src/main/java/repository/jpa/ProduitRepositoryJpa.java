package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import boulangerie.context.Application;
import model.Produit;
import repository.IProduitRepository;
import repository.IRepository;

public class ProduitRepositoryJpa implements IProduitRepository{


public Produit findById(Integer id) {
		
		Produit produit = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			produit = em.find(Produit.class, id);

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

		return produit;
	}
		

	
	@Override
	public List<Produit> findAll() {
		
		List<Produit> produits = new ArrayList();
		Produit i = null;
		

		EntityManager em = null;
		EntityTransaction tx = null;

		
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Produit> query = em.createQuery("select p from Produit p", Produit.class);

			produits = query.getResultList();

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

		return produits;
	}
	

	
	@Override 
	public Produit save(Produit produit) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			produit = em.merge(produit);

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

		return produit;
	}
	

	@Override
	public void deleteById(Integer id) {
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				TypedQuery<Produit> query = em.createQuery("delete from Produit p where p.id = ?1", Produit.class);
				query.setParameter("id", id);

				query.executeUpdate();

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

		}
	

		@Override
		public void delete(Produit produit) {
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				em.remove(em.merge(produit));

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
			
	}



		@Override
		public List<Produit> findAllByLibelleIngredient(String libelle) {
			List<Produit> produits = new ArrayList<>();

			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				TypedQuery<Produit> query = em.createQuery("select distinct p from Produit p join fetch p.lignesIngredients l where l.ingredient.libelle = ?1", Produit.class);
				
				query.setParameter(1, libelle );
				
				produits = query.getResultList();

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

			return produits;
		}

		
}
	
	