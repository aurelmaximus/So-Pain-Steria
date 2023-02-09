package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.IdException;
import boulangerie.exception.BasiqueException;
import boulangerie.model.Basique;
import boulangerie.repository.BasiqueRepository;



@Service
public class BasiqueService {

	@Autowired
	private BasiqueRepository basiqueRepo;
	
	
	private void checkConstraint(Basique basique) {
		if (basique.getPrix() == null) {
			throw new BasiqueException("prix obligatoire");
		}
		if (basique.getLibelle() == null || basique.getLibelle().isEmpty()) {
			throw new BasiqueException("libelle obligatoire");
		}
	}

	
	private void checkNotNull(Basique basique) {
		if (basique == null) {
			throw new BasiqueException("basique obligatoire");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	public Basique findById(Integer id) {
		checkId(id);
		return basiqueRepo.findById(id).orElseThrow(BasiqueException::new);
	}

	private void checkExist(Basique basique) {
		checkId(basique.getId());
		findById(basique.getId());
	}
	
	
	public Basique create(Basique basique) {
		checkNotNull(basique);
		if (basique.getId() != null) {
			throw new IdException();
		}
		checkConstraint(basique);
		return basiqueRepo.save(basique);
	}
	
	
	public Basique update(Basique basique) {
		checkNotNull(basique);
		checkExist(basique);
		checkConstraint(basique);
		Basique basiqueEnBase = findById(basique.getId());
		basiqueEnBase.setPrix(basique.getPrix());
		basiqueEnBase.setLibelle(basique.getLibelle());
		basiqueEnBase.setCategorie(basique.getCategorie() == null ? basiqueEnBase.getCategorie() : basique.getCategorie());
		
		return basiqueRepo.save(basiqueEnBase);
	}
	
	
	public List<Basique> findAll() {
		return basiqueRepo.findAll();
	}
	
	public void delete(Basique basique) {
		checkExist(basique);
		basiqueRepo.delete(basique);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

	
}
