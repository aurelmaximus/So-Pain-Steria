package boulangerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boulangerie.exception.IdException;
import boulangerie.exception.ArticleFavoriException;
import boulangerie.model.ArticleFavori;
import boulangerie.repository.ArticleFavorisRepository;



@Service
public class ArticleFavorisService {

	@Autowired
	private ArticleFavorisRepository articleFavoriRepo;
	
	
	private void checkConstraint(ArticleFavori articleFavori) {
		if (articleFavori.getClient() == null) {
			throw new ArticleFavoriException("client obligatoire");
		}
		if (articleFavori.getProduit() == null ) {
			throw new ArticleFavoriException("produit obligatoire");
		}
	}

	
	private void checkNotNull(ArticleFavori articleFavori) {
		if (articleFavori == null) {
			throw new ArticleFavoriException("articleFavoris obligatoire");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	public ArticleFavori findById(Integer id) {
		checkId(id);
		return articleFavoriRepo.findById(id).orElseThrow(ArticleFavoriException::new);
	}

	private void checkExist(ArticleFavori articleFavori) {
		checkId(articleFavori.getId());
		findById(articleFavori.getId());
	}
	
	
	public ArticleFavori create(ArticleFavori articleFavori) {
		checkNotNull(articleFavori);
		if (articleFavori.getId() != null) {
			throw new IdException();
		}
		checkConstraint(articleFavori);
		return articleFavoriRepo.save(articleFavori);
	}
	
	
	public ArticleFavori update(ArticleFavori articleFavori) {
		checkNotNull(articleFavori);
		checkExist(articleFavori);
		checkConstraint(articleFavori);
		ArticleFavori articleFavoriEnBase = findById(articleFavori.getId());
		articleFavoriEnBase.setClient(articleFavori.getClient());
		articleFavoriEnBase.setProduit(articleFavori.getProduit());
		
		return articleFavoriRepo.save(articleFavoriEnBase);
	}
	
	
	public List<ArticleFavori> findAll() {
		return articleFavoriRepo.findAll();
	}
	
	public void delete(ArticleFavori articleFavori) {
		checkExist(articleFavori);
		articleFavoriRepo.delete(articleFavori);
	}

	public void delete(Integer id) {
		delete(findById(id));
	}
	

	
}
