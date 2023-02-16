package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.IdException;
import boulangerie.exception.ElaboreException;
import boulangerie.model.Elabore;

import boulangerie.repository.ElaboreRepository;



@Service
public class ElaboreService {

	@Autowired
	private ElaboreRepository elaboreRepo;
	
	
	private void checkConstraint(Elabore elabore) {
		if (elabore.getPrix() == null) {
			throw new ElaboreException("prix obligatoire");
		}
		if (elabore.getLibelle() == null || elabore.getLibelle().isEmpty()) {
			throw new ElaboreException("libelle obligatoire");
		}
	}


	private void checkNotNull(Elabore elabore) {
		if (elabore == null) {
			throw new ElaboreException("elabore obligatoire");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	
	public Elabore findById(Integer id) {
		checkId(id);
		return elaboreRepo.findById(id).orElseThrow(ElaboreException::new);
	}

	private void checkExist(Elabore elabore) {
		checkId(elabore.getId());
		findById(elabore.getId());
	}
	
	
	public Elabore create(Elabore elabore) {
		checkNotNull(elabore);
		if (elabore.getId() != null) {
			throw new IdException();
		}
		checkConstraint(elabore);
		return elaboreRepo.save(elabore);
	}

	public Elabore update(Elabore elabore) {
		checkNotNull(elabore);
		checkExist(elabore);
		checkConstraint(elabore);
		Elabore elaboreEnBase = findById(elabore.getId());
		elaboreEnBase.setPrix(elabore.getPrix());
		elaboreEnBase.setLibelle(elabore.getLibelle());
		elaboreEnBase.setNbParts(elabore.getNbParts());
		
		return elaboreRepo.save(elaboreEnBase);
	}
	
	
	public List<Elabore> findAll() {
		return elaboreRepo.findAll();
	}
	
	public void delete(Elabore elabore) {
		checkExist(elabore);
		elaboreRepo.delete(elabore);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

	
}
