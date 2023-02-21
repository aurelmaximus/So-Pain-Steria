package boulangerie.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import boulangerie.model.Commande;
import boulangerie.model.Commande;
import boulangerie.model.Views;
import boulangerie.repository.CommandeRepository;


@RestController
@RequestMapping("/commande")
public class CommandeRestController {
	@Autowired
	private CommandeRepository commandeRepository;

	@GetMapping("")
	@JsonView(Views.ViewCommande.class)
	public List<Commande> findAll() {
		List<Commande> ingredients = commandeRepository.findAll();

		return ingredients;
	}

	@GetMapping("/{numero}")
	@JsonView(Views.ViewCommande.class)
	public Commande findById(@PathVariable Integer numero) {
		Optional<Commande> optCommande = commandeRepository.findById(numero);

		if (optCommande.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCommande.get();
	}
	
	@GetMapping("/{numero}/ligne")
	@JsonView(Views.ViewCommandeWithLignesCommande.class)
	public Commande lignecommandeById(@PathVariable Integer numero) {
		Optional<Commande> optCommande = commandeRepository.findByIdWithLigneCommande(numero);

		if (optCommande.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCommande.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewCommande.class)
	public Commande create(@RequestBody Commande commande) {
		commande = commandeRepository.save(commande);

		return commande;
	}

	@PutMapping("/{numero}")
	@JsonView(Views.ViewCommande.class)
	public Commande update(@RequestBody Commande commande, @PathVariable Integer numero) {
		if (numero != commande.getNumero()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!commandeRepository.existsById(numero)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		commande = commandeRepository.save(commande);

		return commande;
	}

	@DeleteMapping("/{numero}")
	public void delete(@PathVariable Integer numero) {
		commandeRepository.deleteById(numero);
	}

}
