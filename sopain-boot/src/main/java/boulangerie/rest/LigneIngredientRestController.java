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

import boulangerie.model.LigneIngredient;
import boulangerie.model.Views;
import boulangerie.repository.LigneIngredientRepository;


@RestController
@RequestMapping("/ligneIngredient")
public class LigneIngredientRestController {
	@Autowired
	private LigneIngredientRepository ligneIngredientRepository;

	@GetMapping("")
	@JsonView(Views.ViewLigneIngredient.class)
	public List<LigneIngredient> findAll() {
		List<LigneIngredient> ligneIngredients = ligneIngredientRepository.findAll();

		return ligneIngredients;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLigneIngredient.class)
	public LigneIngredient findById(@PathVariable Integer id) {
		Optional<LigneIngredient> optIngredient = ligneIngredientRepository.findById(id);

		if (optIngredient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optIngredient.get();
	}


	@PostMapping("")
	@JsonView(Views.ViewLigneIngredient.class)
	public LigneIngredient create(@RequestBody LigneIngredient ligneIngredient) {
		ligneIngredient = ligneIngredientRepository.save(ligneIngredient);

		return ligneIngredient;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLigneIngredient.class)
	public LigneIngredient update(@RequestBody LigneIngredient ligneIngredient, @PathVariable Integer id) {
		if (id != ligneIngredient.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!ligneIngredientRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		ligneIngredient = ligneIngredientRepository.save(ligneIngredient);

		return ligneIngredient;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		ligneIngredientRepository.deleteById(id);
	}

}
