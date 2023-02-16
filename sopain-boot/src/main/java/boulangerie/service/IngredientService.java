package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.IdException;
import boulangerie.exception.IngredientException;
import boulangerie.model.Ingredient;
import boulangerie.model.Produit;
import boulangerie.repository.IngredientRepository;



@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepo;
	
	
	private void checkConstraint(Ingredient ingredient) {
		if (ingredient.getLibelle() == null || ingredient.getLibelle().isEmpty()) {
			throw new IngredientException("Libelle obligatoire");
		}
	}

	
	private void checkNotNull(Ingredient ingredient) {
		if (ingredient == null) {
			throw new IngredientException("Ingredient vide");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	public Ingredient findById(Integer id) {
		checkId(id);
		return ingredientRepo.findById(id).orElseThrow(IngredientException::new);
	}

	private void checkExist(Ingredient ingredient) {
		checkId(ingredient.getId());
		findById(ingredient.getId());
	}
	
	
	public Ingredient create(Ingredient ingredient) {
		checkNotNull(ingredient);
		if (ingredient.getId() != null) {
			throw new IdException();
		}
		checkConstraint(ingredient);
		return ingredientRepo.save(ingredient);
	}
	
	
	public Ingredient update(Ingredient ingredient) {
		checkNotNull(ingredient);
		checkExist(ingredient);
		checkConstraint(ingredient);
		Ingredient ingredientEnBase = findById(ingredient.getId());
		ingredientEnBase.setAllergene(ingredient.isAllergene());
		ingredientEnBase.setLibelle(ingredient.getLibelle());
				
		return ingredientRepo.save(ingredientEnBase);
	}
	
	
	public List<Ingredient> findAll() {
		return ingredientRepo.findAll();
	}
	
	public List<Ingredient> findByLignesingredientProduit(Produit produit) {
		return ingredientRepo.findByLignesingredientProduitLibelle(produit.getLibelle());
	}
	
	public List<Ingredient> findByLignesingredientProduit(String produitLibelle) {
		return findByLignesingredientProduit(produitLibelle);
	}
	
	public void delete(Ingredient ingredient) {
		checkExist(ingredient);
		ingredientRepo.delete(ingredient);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

	
}
