package boulangerie.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import boulangerie.config.AppConfig;
import boulangerie.exception.ElaboreException;
import boulangerie.model.Elabore;
import boulangerie.service.ElaboreService;


@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
class ElaboreServiceTest {
	@Autowired
	ElaboreService elaboreSrv;

	@Test
	void testCreate() {
		BigDecimal bd = new BigDecimal("2.70");
		Elabore elabore = new Elabore(bd,"Fraisier",6);
		elaboreSrv.create(elabore);
		assertNotNull(elaboreSrv.findById(elabore.getId()));
		assertThrows(ElaboreException.class, () -> {
			elaboreSrv.create(new Elabore());
		});
	}

	@Test
	void testUpdate() {
		BigDecimal bd = new BigDecimal("2.35");
		Elabore elabore = new Elabore(bd,"Paris_brest",6);
		elaboreSrv.create(elabore);
		elaboreSrv.update(elabore);
		elabore = elaboreSrv.findById(elabore.getId());
	
	}

	@Test
	void testFindAll() {
		assertTrue(elaboreSrv.findAll().isEmpty());
		BigDecimal bd = new BigDecimal("2.35");
		Elabore elabore = new Elabore(bd,"Paris_brest",6);
		elaboreSrv.create(elabore);

		assertEquals(1, elaboreSrv.findAll().size());

	}

	@Test
	void testDeleteElabore() {
		BigDecimal bd = new BigDecimal("2.35");
		Elabore elabore = new Elabore(bd,"Paris_brest",6);
		elaboreSrv.create(elabore);
		elaboreSrv.delete(elabore);
		assertThrows(ElaboreException.class, () -> {
			elaboreSrv.findById(elabore.getId());
		});
	}

	@Test
	void testDeleteInteger() {
		BigDecimal bd = new BigDecimal("2.35");
		Elabore elabore = new Elabore(bd,"Paris_brest",6);
		elaboreSrv.create(elabore);
		elaboreSrv.delete(elabore.getId());
		assertThrows(ElaboreException.class, () -> {
			elaboreSrv.findById(elabore.getId());
		});
	}

}
