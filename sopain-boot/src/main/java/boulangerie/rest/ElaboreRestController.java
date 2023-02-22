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

import boulangerie.model.Basique;
import boulangerie.model.Elabore;
import boulangerie.model.Views;
import boulangerie.repository.ElaboreRepository;


@RestController
@RequestMapping("/elabore")
public class ElaboreRestController {
	@Autowired
	private ElaboreRepository elaboreRepository;

	@GetMapping("")
	@JsonView(Views.ViewProduit.class)
	public List<Elabore> findAll() {
		List<Elabore> elabores = elaboreRepository.findAll();

		return elabores;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewProduit.class)
	public Elabore findById(@PathVariable Integer id) {
		Optional<Elabore> optElabore = elaboreRepository.findById(id);

		if (optElabore.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optElabore.get();
	}
	
	@GetMapping("/{id}/ligne")
	@JsonView(Views.ViewCommandeWithLignesIngredient.class)
	public Elabore ligneingredientById(@PathVariable Integer id) {
		Optional<Elabore> optElabore = elaboreRepository.findByIdWithLigneIngredient(id);

		if (optElabore.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optElabore.get();
	}



	@PostMapping("")
	@JsonView(Views.ViewProduit.class)
	public Elabore create(@RequestBody Elabore elabore) {
		elabore = elaboreRepository.save(elabore);

		return elabore;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewProduit.class)
	public Elabore update(@RequestBody Elabore elabore, @PathVariable Integer id) {
		if (id != elabore.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!elaboreRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		elabore = elaboreRepository.save(elabore);

		return elabore;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		elaboreRepository.deleteById(id);
	}

}
