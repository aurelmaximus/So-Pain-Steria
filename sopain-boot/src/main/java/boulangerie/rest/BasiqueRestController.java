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
import boulangerie.model.Views;
import boulangerie.repository.BasiqueRepository;



@RestController
@RequestMapping("/basique")
public class BasiqueRestController {
	@Autowired
	private BasiqueRepository basiqueRepository;

	@GetMapping("")
	@JsonView(Views.ViewBasique.class)
	public List<Basique> findAll() {
		List<Basique> basiques = basiqueRepository.findAll();

		return basiques;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewBasique.class)
	public Basique findById(@PathVariable Integer id) {
		Optional<Basique> optBasique = basiqueRepository.findById(id);

		if (optBasique.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optBasique.get();
	}


	@PostMapping("")
	@JsonView(Views.ViewBasique.class)
	public Basique create(@RequestBody Basique basique) {
		basique = basiqueRepository.save(basique);

		return basique;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewBasique.class)
	public Basique update(@RequestBody Basique basique, @PathVariable Integer id) {
		if (id != basique.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!basiqueRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		basique = basiqueRepository.save(basique);

		return basique;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		basiqueRepository.deleteById(id);
	}

}
