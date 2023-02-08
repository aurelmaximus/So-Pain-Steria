package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.IdException;
import boulangerie.exception.ElaboreException;
import boulangerie.model.Produit;
import boulangerie.repository.ElaboreRepository;


@Service
public class BasiqueService {

	@Autowired
	private ElaboreRepository produitRepo;
	

	private void checkConstraint(Produit produit) {
		if (produit.getPrix() == null) {
			throw new ElaboreException("prix obligatoire");
		}
		if (produit.getLibelle() == null || produit.getLibelle().isEmpty()) {
			throw new ElaboreException("libelle obligatoire");
		}
	}

	private void checkNotNull(Produit produit) {
		if (produit == null) {
			throw new ElaboreException("produit obligatoire");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	public Produit findById(Integer id) {
		checkId(id);
		return produitRepo.findById(id).orElseThrow(ElaboreException::new);
	}

	private void checkExist(Produit produit) {
		checkId(produit.getId());
		findById(produit.getId());
	}
	
	
	public Produit create(Produit produit) {
		checkNotNull(produit);
		if (produit.getId() != null) {
			throw new IdException();
		}
		checkConstraint(produit);
		return produitRepo.save(produit);
	}

	public Produit update(Produit produit) {
		checkNotNull(produit);
		checkExist(produit);
		checkConstraint(produit);
		Produit produitEnBase = findById(produit.getId());
		produitEnBase.setPrix(produit.getPrix());
		produitEnBase.setLibelle(produit.getLibelle());
		
		return produitRepo.save(produitEnBase);
	}
	
	public List<Produit> findAll() {
		return produitRepo.findAll();
	}
	
	public void delete(Produit produit) {
		checkExist(produit);
		produitRepo.delete(produit);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

	
}
