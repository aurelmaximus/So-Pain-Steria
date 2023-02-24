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
import boulangerie.model.Compte;
import boulangerie.model.Views;
import boulangerie.repository.ClientRepository;
import boulangerie.repository.CompteRepository;
import boulangerie.rest.dto.AuthDTO;


@RestController
@RequestMapping("/compte")
@CrossOrigin("*")
public class ComptetRestController2 {



	@Autowired
	private CompteRepository compteRepository;

	@GetMapping("")
	@JsonView(Views.ViewCompte.class)
	public List<Compte> findAll() {
		List<Compte> comptes = compteRepository.findAll();

		return comptes;
	}
	
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte findById(@PathVariable Integer id) {
		Optional<Compte> optCompte = compteRepository.findById(id);

		if (optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompte.get();
	}
	
	@PostMapping("")
	@JsonView(Views.ViewCompte.class)
	public Compte create(@RequestBody Compte compte) {
		compte = compteRepository.save(compte);

		return compte;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte update(@RequestBody Compte compte, @PathVariable Integer id) {
		if (id != compte.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!compteRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		compte = compteRepository.save(compte);

		return compte;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		compteRepository.deleteById(id);
	}
	
	@PostMapping("/auth")
	public Compte auth(@RequestBody AuthDTO authDTO) {
		Optional<Compte> optCompte = compteRepository.findByEmailAndPassword(authDTO.getLogin(), authDTO.getPassword());
	
		if(optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optCompte.get();	
	}

}



