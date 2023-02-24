package boulangerie.rest;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import boulangerie.model.Client;
import boulangerie.model.Views;
import boulangerie.repository.ClientRepository;


@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientRestController {

	
	
		@Autowired
		private ClientRepository clientRepository;

		@GetMapping("")
		@JsonView(Views.ViewClient.class)
		public List<Client> findAll() {
			List<Client> clients = clientRepository.findAll();

			return clients;
		}

		@GetMapping("/{id}")
		@JsonView(Views.ViewClient.class)
		public Client findById(@PathVariable Integer id) {
			Optional<Client> optClient = clientRepository.findById(id);

			if (optClient.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			return optClient.get();
		}
		
		@GetMapping("/{id}/commandes")
		@JsonView(Views.ViewClientWithCommandes.class)
		public Client commandeById(@PathVariable Integer id) {
			Optional<Client> optClient = clientRepository.findByIdWithCommandes(id);

			if (optClient.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			return optClient.get();
		}
		
		@GetMapping("/{id}/articlesfavoris")
		@JsonView(Views.ViewClientWithArticlesFavoris.class)
		public Client articlesfavorisById(@PathVariable Integer id) {
			Optional<Client> optClient = clientRepository.findByIdWitharticlesfavori(id);

			if (optClient.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			return optClient.get();
		}

		
		
		
		@PostMapping("")
		@JsonView(Views.ViewClient.class)
		public Client create(@RequestBody Client client) {
			client = clientRepository.save(client);

			return client;
		}

		@PutMapping("/{id}")
		@JsonView(Views.ViewClient.class)
		public Client update(@RequestBody Client client, @PathVariable Integer id) {
			if (id != client.getId()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}

			if (!clientRepository.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			client = clientRepository.save(client);

			return client;
		}

		@DeleteMapping("/{id}")
		public void delete(@PathVariable Integer id) {
			clientRepository.deleteById(id);
		}

	}

	

