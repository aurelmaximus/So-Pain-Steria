package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.IdException;
import boulangerie.exception.LigneIngredientException;
import boulangerie.model.LigneIngredient;
import boulangerie.repository.LigneIngredientRepository;



@Service
public class LigneIngredientService {

	@Autowired
	private LigneIngredientRepository lignesIngredientRepo;
	
	
	private void checkConstraint(LigneIngredient lignesIngredient) {
		if (lignesIngredient.getIngredient() == null) {
			throw new LigneIngredientException("Ingredient obligatoire");
		}
		if (lignesIngredient.getProduit() == null) {
			throw new LigneIngredientException("Produit obligatoire");
		}
	}

	
	private void checkNotNull(LigneIngredient lignesIngredient) {
		if (lignesIngredient == null) {
			throw new LigneIngredientException("lignesIngredient nulle");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	public LigneIngredient findById(Integer id) {
		checkId(id);
		return lignesIngredientRepo.findById(id).orElseThrow(LigneIngredientException::new);
	}

	private void checkExist(LigneIngredient lignesIngredient) {
		checkId(lignesIngredient.getId());
		findById(lignesIngredient.getId());
	}
	
	
	public LigneIngredient create(LigneIngredient lignesIngredient) {
		checkNotNull(lignesIngredient);
		if (lignesIngredient.getId() != null) {
			throw new IdException();
		}
		checkConstraint(lignesIngredient);
		return lignesIngredientRepo.save(lignesIngredient);
	}
	
	
	public LigneIngredient update(LigneIngredient lignesIngredient) {
		checkNotNull(lignesIngredient);
		checkExist(lignesIngredient);
		checkConstraint(lignesIngredient);
		LigneIngredient lignesIngredientEnBase = findById(lignesIngredient.getId());
		lignesIngredientEnBase.setIngredient(lignesIngredient.getIngredient());
		lignesIngredientEnBase.setProduit(lignesIngredient.getProduit());
		
		return lignesIngredientRepo.save(lignesIngredientEnBase);
	}
	
	
	public List<LigneIngredient> findAll() {
		return lignesIngredientRepo.findAll();
	}
	
	public void delete(LigneIngredient lignesIngredient) {
		checkExist(lignesIngredient);
		lignesIngredientRepo.delete(lignesIngredient);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

	
}
