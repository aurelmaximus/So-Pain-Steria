package boulangerie.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import boulangerie.config.AppConfig;
import boulangerie.exception.BasiqueException;
import boulangerie.model.Basique;
import boulangerie.model.Categorie;
import boulangerie.service.BasiqueService;

@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
class BasiqueServiceTest {
	@Autowired
	BasiqueService basiqueSrv;

	
	@Test
	void testCreate() {
		BigDecimal bd = new BigDecimal("2.70");
		Basique basique = new Basique(bd,"Chocolatine",Categorie.Viennoiserie);
		basiqueSrv.create(basique);
		assertNotNull(basiqueSrv.findById(basique.getId()));
		assertThrows(BasiqueException.class, () -> {
			basiqueSrv.create(new Basique());
		});
	}

	@Test
	void testUpdate() {
		BigDecimal bd = new BigDecimal("2.35");
		Basique basique = new Basique(bd,"Croissant",Categorie.Viennoiserie);
		basiqueSrv.create(basique);
		basiqueSrv.update(basique);
		basique = basiqueSrv.findById(basique.getId());
		
	}

	@Test
	void testFindAll() {
		assertTrue(basiqueSrv.findAll().isEmpty());
		BigDecimal bd = new BigDecimal("2.35");
		Basique basique = new Basique(bd,"Croissant",Categorie.Viennoiserie);
		basiqueSrv.create(basique);

		assertEquals(1, basiqueSrv.findAll().size());

	}

	@Test
	void testDeleteBasique() {
		BigDecimal bd = new BigDecimal("2.35");
		Basique basique = new Basique(bd,"Croissant",Categorie.Viennoiserie);
		basiqueSrv.create(basique);
		basiqueSrv.delete(basique);
		assertThrows(BasiqueException.class, () -> {
			basiqueSrv.findById(basique.getId());
		});
	}

	@Test
	void testDeleteInteger() {
		BigDecimal bd = new BigDecimal("2.35");
		Basique basique = new Basique(bd,"Croissant",Categorie.Viennoiserie);
		basiqueSrv.create(basique);
		basiqueSrv.delete(basique.getId());
		assertThrows(BasiqueException.class, () -> {
			basiqueSrv.findById(basique.getId());
		});
	}

}
