package quest.rest;

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

import boulangerie.model.Ingredient;
import boulangerie.model.Views;
import boulangerie.repository.IngredientRepository;


@RestController
@RequestMapping("/ingredient")
public class IngredientRestController {
	@Autowired
	private IngredientRepository ingredientRepository;

	@GetMapping("")
	@JsonView(Views.ViewIngredient.class)
	public List<Ingredient> findAll() {
		List<Ingredient> ingredients = ingredientRepository.findAll();

		return ingredients;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewIngredient.class)
	public Ingredient findById(@PathVariable Integer id) {
		Optional<Ingredient> optIngredient = ingredientRepository.findById(id);

		if (optIngredient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optIngredient.get();
	}

	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewIngredientWithStagiaires.class)
	public Ingredient detailById(@PathVariable Integer id) {
		Optional<Ingredient> optIngredient = ingredientRepository.findByIdWithStagiaires(id);

		if (optIngredient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optIngredient.get();
	}
	
	@GetMapping("/{id}/matieres")
	@JsonView(Views.ViewMatiere.class)
	public List<Matiere> findAll(@PathVariable Integer id) {
		List<Matiere> matieres = matiereRepository.findAllByIngredient(id);

		return matieres;
	}

	@PostMapping("")
	@JsonView(Views.ViewIngredient.class)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		ingredient = ingredientRepository.save(ingredient);

		return ingredient;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewIngredient.class)
	public Ingredient update(@RequestBody Ingredient ingredient, @PathVariable Integer id) {
		if (id != ingredient.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!ingredientRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		ingredient = ingredientRepository.save(ingredient);

		return ingredient;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		ingredientRepository.deleteById(id);
	}

}
