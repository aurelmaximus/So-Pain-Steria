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
import model.Produit;
import repository.IProduitRepository;

@Repository
public class ProduitRepositoryJpa implements IProduitRepository{

	@PersistenceContext
	private EntityManager em;

	public Produit findById(Integer id) {

		Produit produit = null;
		produit = em.find(Produit.class, id);

		return produit;
	}



	@Override
	public List<Produit> findAll() {

		List<Produit> produits = new ArrayList<>();

		TypedQuery<Produit> query = em.createQuery("select p from Produit p", Produit.class);
		produits = query.getResultList();

		return produits;
	}



	@Override
	@Transactional
	public Produit save(Produit produit) {

		produit = em.merge(produit);

		return produit;
	}


	@Override
	@Transactional
	public void deleteById(Integer id) {

		TypedQuery<Produit> query = em.createQuery("delete from Produit p where p.id = ?1", Produit.class);
		query.setParameter("id", id);

		query.executeUpdate();

	}


	@Override
	@Transactional
	public void delete(Produit produit) {

		em.remove(em.merge(produit));

	}



	@Override
	public List<Produit> findAllByLibelleIngredient(String libelle) {

		List<Produit> produits = new ArrayList<>();

		TypedQuery<Produit> query = em.createQuery("select distinct p from Produit p join fetch p.lignesIngredients l where l.ingredient.libelle = ?1", Produit.class);
		query.setParameter(1, libelle );
		produits = query.getResultList();

		return produits;
	}


}

