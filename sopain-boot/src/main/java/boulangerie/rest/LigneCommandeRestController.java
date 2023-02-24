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

import boulangerie.model.LigneCommande;
import boulangerie.model.Views;
import boulangerie.repository.LigneCommandeRepository;


@RestController
@RequestMapping("/lignecommande")
@CrossOrigin("*")
public class LigneCommandeRestController {
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;

	@GetMapping("")
	@JsonView(Views.ViewLigneCommande.class)
	public List<LigneCommande> findAll() {
		List<LigneCommande> ligneCommandes = ligneCommandeRepository.findAll();

		return ligneCommandes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLigneCommande.class)
	public LigneCommande findById(@PathVariable Integer id) {
		Optional<LigneCommande> optLigneCommande = ligneCommandeRepository.findById(id);

		if (optLigneCommande.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optLigneCommande.get();
	}


	@PostMapping("")
	@JsonView(Views.ViewLigneCommande.class)
	public LigneCommande create(@RequestBody LigneCommande ligneCommande) {
		ligneCommande = ligneCommandeRepository.save(ligneCommande);

		return ligneCommande;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLigneCommande.class)
	public LigneCommande update(@RequestBody LigneCommande ligneCommande, @PathVariable Integer id) {
		if (id != ligneCommande.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!ligneCommandeRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		ligneCommande = ligneCommandeRepository.save(ligneCommande);

		return ligneCommande;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		ligneCommandeRepository.deleteById(id);
	}

}
