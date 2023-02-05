package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import boulangerie.model.LigneIngredient;
import boulangerie.repository.ILigneIngredientRepository;

@Repository
public class LigneIngredientRepositoryJpa implements ILigneIngredientRepository {

	@PersistenceContext
	private EntityManager em;


	public LigneIngredient findById(Integer id) {

		LigneIngredient ligneIngredient = null;
		ligneIngredient = em.find(LigneIngredient.class, id);

		return ligneIngredient;
	}



	@Override
	public List<LigneIngredient> findAll() {

		List<LigneIngredient> ligneIngredients = new ArrayList();

		TypedQuery<LigneIngredient> query = em.createQuery("select i from LigneIngredient i", LigneIngredient.class);
		ligneIngredients = query.getResultList();

		return ligneIngredients;
	}



	@Override 
	@Transactional
	public LigneIngredient save(LigneIngredient ligneIngredient) {

		ligneIngredient = em.merge(ligneIngredient);
		return ligneIngredient;
	}


	@Override
	@Transactional
	public void deleteById(Integer id) {

		TypedQuery<LigneIngredient> query = em.createQuery("delete from LigneIngredient i where i.id = ?1", LigneIngredient.class);
		query.setParameter("id", id);

		query.executeUpdate();

	}


	@Override
	@Transactional
	public void delete(LigneIngredient ligneIngredient) {

		em.remove(em.merge(ligneIngredient));

	}



	@Override
	public List<LigneIngredient> findAllByLibelleProduit(String libelle) {
		List<LigneIngredient> ingredients = new ArrayList<>();

		TypedQuery<LigneIngredient> query = em.createQuery("select li from LigneIngredient li join li.produit p where p.libelle = ?1", LigneIngredient.class);

		query.setParameter(1, libelle);				
		ingredients = query.getResultList();



		return ingredients;		

	}








}
