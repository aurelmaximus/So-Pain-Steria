package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.ClientException;
import boulangerie.exception.EmployeException;
import boulangerie.exception.IdException;
import boulangerie.model.Employe;
import boulangerie.repository.EmployeRepository;

@Service
public class EmployeService {
	
	@Autowired
	private EmployeRepository employeRepo;

	private void checkConstraint(Employe employe) {
		if (employe.getEmail() == null || employe.getEmail().isEmpty()) {
			throw new ClientException("email obligatoire");
		}
		if (employe.getPassword() == null || employe.getPassword().isEmpty()) {
			throw new ClientException("password obligatoire");
		}
		if (employe.getNom() == null || employe.getNom().isEmpty()) {
			throw new EmployeException("nom obligatoire");
		}
		if (employe.getPrenom() == null || employe.getPrenom().isEmpty()) {
			throw new EmployeException("prenom obligatoire");
		}
		if (employe.getAdresse() == null ) {
			throw new EmployeException("adresse obligatoire");
		}
	}

	
	private void checkNotNull(Employe employe) {
		if (employe == null) {
			throw new EmployeException("employe obligatoire");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	public Employe findById(Integer id) {
		checkId(id);
		return employeRepo.findById(id).orElseThrow(EmployeException::new);
	}

	private void checkExist(Employe employe) {
		checkId(employe.getId());
		findById(employe.getId());
	}
	
	
	public Employe create(Employe employe) {
		checkNotNull(employe);
		if (employe.getId() != null) {
			throw new IdException();
		}
		checkConstraint(employe);
		return employeRepo.save(employe);
	}
	
	
	public Employe update(Employe employe) {
		checkNotNull(employe);
		checkExist(employe);
		checkConstraint(employe);
		Employe employeEnBase = findById(employe.getId());
		employeEnBase.setNom(employe.getNom());
		employeEnBase.setPrenom(employe.getPrenom());
		employeEnBase.setAdresse(employe.getAdresse() == null ? employeEnBase.getAdresse() : employe.getAdresse());
		
		return employeRepo.save(employeEnBase);
	}
	
	
	public List<Employe> findAll() {
		return employeRepo.findAll();
	}
	
	public void delete(Employe employe) {
		checkExist(employe);
		employeRepo.delete(employe);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

	
}
