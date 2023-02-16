package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.CommandeException;
import boulangerie.exception.IdException;
import boulangerie.model.Commande;
import boulangerie.repository.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepo;
//	@Autowired
//	private ClientRepository clientRepo;


	public Commande create(Commande commande) {
		checkNotNull(commande);
		if (commande.getNumero() != null) {
			throw new IdException();
		}
		checkConstraint(commande);
		return commandeRepo.save(commande);
	}

	private void checkConstraint(Commande commande) {
		if (commande.getDateArrivee() == null ) {
			throw new CommandeException("Date est obligatoire");
		}
		if (commande.getHeureArrive() == null ) {
			throw new CommandeException("Heure d'arrivee est  obligatoire");
		}
		if (commande.getEtatcommande()==null) {
			throw new CommandeException("Etat de commande est  obligatoire");
		}
		
		
//		if (commande.getClient().getId() == null  ) {
//			throw new CommandeException("id client est obligatoire");
//		}
//		if (commande.isSurPlace() == null) {
//			throw new CommandeException("sur place ou non  est  obligatoire");
//		}
	}

	private void checkNotNull(Commande commande) {
		if (commande == null) {
			throw new CommandeException("commande obligatoire");
		}
	}

	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}

	private void checkExist(Commande commande) {
		checkId(commande.getNumero());
		findById(commande.getNumero());
	}

	public Commande findById(Integer numero) {
		checkId(numero);
		return commandeRepo.findById(numero).orElseThrow(CommandeException::new);
	}

	public Commande update(Commande commande) {
		checkNotNull(commande);
		checkExist(commande);
		checkConstraint(commande);
		Commande commandeEnBase = findById(commande.getNumero());
		commandeEnBase.setDateArrivee(commande.getDateArrivee() == null ? commande.getDateArrivee() : commande.getDateArrivee());
		commandeEnBase.setHeureArrive(commande.getHeureArrive() == null ? commande.getHeureArrive() : commande.getHeureArrive());
		commandeEnBase.setEtatcommande(commande.getEtatcommande());
		commandeEnBase.setSurPlace(commande.isSurPlace());
	

		return commandeRepo.save(commandeEnBase);
	}

	public List<Commande> findAll() {
		return commandeRepo.findAll();
	}

	public void delete(Commande commande) {
		checkExist(commande);
//		clientRepo.setReferentToNullByReferent(client);
		commandeRepo.delete(commande);
	}

	public void delete(Integer numero) {
		delete(findById(numero));
	}
}
