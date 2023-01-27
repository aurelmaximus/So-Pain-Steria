package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import model.Ingredient;
import boulangerie.context.Application;
import repository.IRepository;
import repository.IIngredientRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class IngredientRepositoryJpa implements IRepository<Ingredient, Integer> {


	
	public Ingredient findById(Integer id) {
		
		Ingredient ingredient = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			ingredient = em.find(Ingredient.class, id);

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

		return ingredient;
	}
		

	
	@Override
	public List<Ingredient> findAll() {
		
		List<Ingredient> ingredients = new ArrayList();
		Ingredient i = null;
		

		EntityManager em = null;
		EntityTransaction tx = null;

		
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Ingredient> query = em.createQuery("select i from Ingredient i", Ingredient.class);

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

		return ingredients;
	}
	

	
	@Override 
	public Ingredient save(Ingredient ingredient) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			ingredient = em.merge(ingredient);

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

		return ingredient;
	}
	

	@Override
	public void deleteById(Integer id) {
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				TypedQuery<Ingredient> query = em.createQuery("delete from Ingredient i where i.id = ?1", Ingredient.class);
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
		public void delete(Ingredient ingredient) {
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				em.remove(em.merge(ingredient));

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

	
}
