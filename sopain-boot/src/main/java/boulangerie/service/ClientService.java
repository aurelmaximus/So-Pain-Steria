package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.ClientException;
import boulangerie.exception.IdException;
import boulangerie.model.Client;
import boulangerie.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepo;

	private void checkConstraint(Client client) {
		if (client.getEmail() == null || client.getEmail().isEmpty()) {
			throw new ClientException("email obligatoire");
		}
		if (client.getPassword() == null || client.getPassword().isEmpty()) {
			throw new ClientException("password obligatoire");
		}
		if (client.getNom() == null || client.getNom().isEmpty()) {
			throw new ClientException("nom obligatoire");
		}
		if (client.getPrenom() == null || client.getPrenom().isEmpty()) {
			throw new ClientException("prenom obligatoire");
		}
		if (client.getAdresse() == null ) {
			throw new ClientException("adresse obligatoire");
		}
	}

	
	private void checkNotNull(Client client) {
		if (client == null) {
			throw new ClientException("client obligatoire");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	public Client findById(Integer id) {
		checkId(id);
		return clientRepo.findById(id).orElseThrow(ClientException::new);
	}

	private void checkExist(Client client) {
		checkId(client.getId());
		findById(client.getId());
	}
	
	
	public Client create(Client client) {
		checkNotNull(client);
		if (client.getId() != null) {
			throw new IdException();
		}
		checkConstraint(client);
		return clientRepo.save(client);
	}
	
	
	public Client update(Client client) {
		checkNotNull(client);
		checkExist(client);
		checkConstraint(client);
		Client clientEnBase = findById(client.getId());
		clientEnBase.setNom(client.getNom());
		clientEnBase.setPrenom(client.getPrenom());
		clientEnBase.setAdresse(client.getAdresse() == null ? clientEnBase.getAdresse() : client.getAdresse());
		
		return clientRepo.save(clientEnBase);
	}
	
	
	public List<Client> findAll() {
		return clientRepo.findAll();
	}
	
	public void delete(Client client) {
		checkExist(client);
		clientRepo.delete(client);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

}
