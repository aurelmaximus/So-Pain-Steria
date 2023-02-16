package boulangerie.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import boulangerie.config.AppConfig;
import boulangerie.exception.LigneCommandeException;
import boulangerie.model.LigneCommande;
import boulangerie.service.LigneCommandeService;



@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
class LigneCommandeServiceTest {
	@Autowired
	LigneCommandeService ligneCommandeSrv;

	@Test
	void testCreate() {
		BigDecimal bb = new BigDecimal(33);
		LigneCommande ligneCommande = new LigneCommande(12,bb);
		ligneCommandeSrv.create(ligneCommande);
		assertNotNull(ligneCommandeSrv.findById(ligneCommande.getId()));
		assertThrows(LigneCommandeException.class, () -> {
			ligneCommandeSrv.create(new LigneCommande());
		});
	}

	@Test
	void testUpdate() {
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommandeSrv.create(ligneCommande);
		ligneCommande.setQte(33);
		BigDecimal a = new BigDecimal(22);
		ligneCommande.setTotal(a);
		ligneCommandeSrv.update(ligneCommande);
		ligneCommande = ligneCommandeSrv.findById(ligneCommande.getId());
		assertEquals(33, ligneCommande.getQte());
		assertEquals(a, ligneCommande.getTotal());
		// ...mettre les autres assertEquals pour l'adresse
		

	}

	@Test
	void testFindAll() {
		assertTrue(ligneCommandeSrv.findAll().isEmpty());
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommandeSrv.create(ligneCommande);

		assertEquals(1, ligneCommandeSrv.findAll().size());

	}

	@Test
	void testDeleteLigneCommande() {
		BigDecimal bb = new BigDecimal(33);
		LigneCommande ligneCommande = new LigneCommande(12,bb);
		ligneCommandeSrv.create(ligneCommande);
		ligneCommandeSrv.delete(ligneCommande);
		assertThrows(LigneCommandeException.class, () -> {
			ligneCommandeSrv.findById(ligneCommande.getId());
		});
	}

	@Test
	void testDeleteInteger() {
		BigDecimal bb = new BigDecimal(33);
		LigneCommande ligneCommande = new LigneCommande(12,bb);
		ligneCommandeSrv.create(ligneCommande);
		ligneCommandeSrv.delete(ligneCommande.getId());
		assertThrows(LigneCommandeException.class, () -> {
			ligneCommandeSrv.findById(ligneCommande.getId());
		});
	}

}
