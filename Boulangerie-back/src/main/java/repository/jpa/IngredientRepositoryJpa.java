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
import model.Ingredient;
import repository.IIngredientRepository;

@Repository
public class IngredientRepositoryJpa implements IIngredientRepository {

	@PersistenceContext
	private EntityManager em;

	public Ingredient findById(Integer id) {

		Ingredient ingredient = null;

		ingredient = em.find(Ingredient.class, id);
		return ingredient;
	}



	@Override
	public List<Ingredient> findAll() {

		List<Ingredient> ingredients = new ArrayList<>();

		TypedQuery<Ingredient> query = em.createQuery("select i from Ingredient i", Ingredient.class);
		ingredients = query.getResultList();

		return ingredients;
	}



	@Override
	@Transactional
	public Ingredient save(Ingredient ingredient) {

		ingredient = em.merge(ingredient);

		return ingredient;
	}


	@Override
	@Transactional
	public void deleteById(Integer id) {

		TypedQuery<Ingredient> query = em.createQuery("delete from Ingredient i where i.id = ?1", Ingredient.class);
		query.setParameter("id", id);

		query.executeUpdate();

	}


	@Override
	@Transactional
	public void delete(Ingredient ingredient) {

		em.remove(em.merge(ingredient));

	}



	@Override
	public List<Ingredient> findAllByLibelleProduit(String libelle) {

		List<Ingredient> ingredients = new ArrayList<>();

		TypedQuery<Ingredient> query = em.createQuery("select li.ingredient from LigneIngredient li where li.produit.libelle = ?1", Ingredient.class);
		query.setParameter(1, libelle);
		ingredients = query.getResultList();


		return ingredients;		

	}




}
