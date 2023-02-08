package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import boulangerie.config.AppConfig;
import boulangerie.exception.ElaboreException;
import boulangerie.model.Produit;
import boulangerie.service.ElaboreService;


@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
class ElaboreServiceTest {
	@Autowired
	ElaboreService produitSrv;

	@Test
	void testCreate() {
		BigDecimal bd = new BigDecimal("2.70");
		Produit produit = new Produit(bd,"Chocolatine");
		produitSrv.create(produit);
		assertNotNull(produitSrv.findById(produit.getId()));
		assertThrows(ElaboreException.class, () -> {
			produitSrv.create(new Produit());
		});
	}

	@Test
	void testUpdate() {
		Produit formateur = new Produit(Civilite.M, "gozlan", "olivier", "olivier", false, 1);
		produitSrv.create(formateur);
		formateur.setExperience(10);
		formateur.setAdresse(new Adresse("rue", "complement", "11111", "paris"));
		produitSrv.update(formateur);
		formateur = produitSrv.findById(formateur.getId());
		assertEquals("rue", formateur.getAdresse().getRue());
		assertEquals("complement", formateur.getAdresse().getComplement());
		// ...mettre les autres assertEquals pour l'adresse
		assertEquals(10, formateur.getExperience());

	}

	@Test
	void testFindAll() {
		assertTrue(produitSrv.findAll().isEmpty());
		Produit formateur = new Produit(Civilite.M, "gozlan", "olivier", "olivier", false, 1);
		produitSrv.create(formateur);

		assertEquals(1, produitSrv.findAll().size());

	}

	@Test
	void testDeleteProduit() {
		Produit formateur = new Produit(Civilite.M, "gozlan", "olivier", "olivier", false, 1);
		produitSrv.create(formateur);
		produitSrv.delete(formateur);
		assertThrows(ElaboreException.class, () -> {
			produitSrv.findById(formateur.getId());
		});
	}

	@Test
	void testDeleteInteger() {
		Produit formateur = new Produit(Civilite.M, "gozlan", "olivier", "olivier", false, 1);
		produitSrv.create(formateur);
		produitSrv.delete(formateur.getId());
		assertThrows(ElaboreException.class, () -> {
			produitSrv.findById(formateur.getId());
		});
	}

}
