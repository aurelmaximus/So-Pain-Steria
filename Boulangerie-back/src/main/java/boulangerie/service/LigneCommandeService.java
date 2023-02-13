package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.IdException;
import boulangerie.exception.LigneCommandeException;
import boulangerie.model.LigneCommande;
import boulangerie.repository.LigneCommandeRepository;



@Service
public class LigneCommandeService {

	@Autowired
	private LigneCommandeRepository lignesCommandeRepo;
	
	
	private void checkConstraint(LigneCommande lignesCommande) {
		if (lignesCommande.getQte()== 0) {
			throw new LigneCommandeException("quantite obligatoire");
		}
			
		if (lignesCommande.getCommande().getNumero() == null) {
			throw new LigneCommandeException("numero de commande obligatoire");
		}
		if (lignesCommande.getProduit() == null) {
			throw new LigneCommandeException("Produit obligatoire");
		}
		
	}

	
	private void checkNotNull(LigneCommande lignesCommande) {
		if (lignesCommande == null) {
			throw new LigneCommandeException("lignesCommande nulle");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	public LigneCommande findById(Integer id) {
		checkId(id);
		return lignesCommandeRepo.findById(id).orElseThrow(LigneCommandeException::new);

	}

	private void checkExist(LigneCommande lignesCommande) {
		checkId(lignesCommande.getId());
		findById(lignesCommande.getId());
	}
	
	
	public LigneCommande create(LigneCommande lignesCommande) {
		checkNotNull(lignesCommande);
		if (lignesCommande.getId() != null) {
			throw new IdException();
		}
		checkConstraint(lignesCommande);
		return lignesCommandeRepo.save(lignesCommande);
	}
	
	
	public LigneCommande update(LigneCommande lignesCommande) {
		checkNotNull(lignesCommande);
		checkExist(lignesCommande);
		checkConstraint(lignesCommande);
		LigneCommande lignesCommandeEnBase = findById(lignesCommande.getId());
		lignesCommandeEnBase.setQte(lignesCommande.getQte());
		lignesCommandeEnBase.setTotal(lignesCommande.getTotal());
		
		return lignesCommandeRepo.save(lignesCommandeEnBase);
	}
	
	
	public List<LigneCommande> findAll() {
		return lignesCommandeRepo.findAll();
	}
	
	public void delete(LigneCommande lignesCommande) {
		checkExist(lignesCommande);
		lignesCommandeRepo.delete(lignesCommande);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

	
}
