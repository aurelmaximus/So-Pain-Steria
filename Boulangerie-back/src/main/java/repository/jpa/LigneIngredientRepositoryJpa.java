package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import boulangerie.context.Application;
import model.Ingredient;
import model.LigneIngredient;
import repository.ILigneIngredientRepository;

public class LigneIngredientRepositoryJpa implements ILigneIngredientRepository {


	
	public LigneIngredient findById(Integer id) {
		
		LigneIngredient ligneIngredient = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			ligneIngredient = em.find(LigneIngredient.class, id);

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

		return ligneIngredient;
	}
		

	
	@Override
	public List<LigneIngredient> findAll() {
		
		List<LigneIngredient> ligneIngredients = new ArrayList();
		LigneIngredient i = null;
		

		EntityManager em = null;
		EntityTransaction tx = null;

		
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<LigneIngredient> query = em.createQuery("select i from LigneIngredient i", LigneIngredient.class);

			ligneIngredients = query.getResultList();

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

		return ligneIngredients;
	}
	

	
	@Override 
	public LigneIngredient save(LigneIngredient ligneIngredient) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			ligneIngredient = em.merge(ligneIngredient);

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

		return ligneIngredient;
	}
	

	@Override
	public void deleteById(Integer id) {
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				TypedQuery<LigneIngredient> query = em.createQuery("delete from LigneIngredient i where i.id = ?1", LigneIngredient.class);
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
		public void delete(LigneIngredient ligneIngredient) {
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				em.remove(em.merge(ligneIngredient));

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
		public List<LigneIngredient> findAllByLibelleProduit(String libelle) {
			List<LigneIngredient> ingredients = new ArrayList<>();

			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				TypedQuery<LigneIngredient> query = em.createQuery("select li from LigneIngredient li join li.produit p where p.libelle = ?1", LigneIngredient.class);

				query.setParameter(1, libelle);
				
				ingredients = query.getResultList();

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

			return ingredients;		}



	
		

		
	
}
