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

import boulangerie.model.ArticleFavori;
import boulangerie.model.Views;
import boulangerie.repository.ArticleFavorisRepository;



@RestController
@RequestMapping("/articleFavoris")
@CrossOrigin("*")
public class ArticleFavoriRestController {
	
	@Autowired
	private ArticleFavorisRepository articlefavorisRepository;

	@GetMapping("")
	@JsonView(Views.ViewArticleFavoris.class)
	public List<ArticleFavori> findAll() {
		List<ArticleFavori> articlesFavoris = articlefavorisRepository.findAll();

		return articlesFavoris;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewArticleFavoris.class)
	public ArticleFavori findById(@PathVariable Integer id) {
		Optional<ArticleFavori> optArticleFavoris = articlefavorisRepository.findById(id);

		if (optArticleFavoris.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optArticleFavoris.get();
	}


	@PostMapping("")
	@JsonView(Views.ViewArticleFavoris.class)
	public ArticleFavori create(@RequestBody ArticleFavori articleFavoris) {
		articleFavoris = articlefavorisRepository.save(articleFavoris);

		return articleFavoris;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewArticleFavoris.class)
	public ArticleFavori update(@RequestBody ArticleFavori articlesFavoris, @PathVariable Integer id) {
		if (id != articlesFavoris.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!articlefavorisRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		articlesFavoris = articlefavorisRepository.save(articlesFavoris);

		return articlesFavoris;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		articlefavorisRepository.deleteById(id);
	}

}
