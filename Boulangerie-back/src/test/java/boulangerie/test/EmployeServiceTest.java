package boulangerie.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import boulangerie.config.AppConfig;
import boulangerie.exception.EmployeException;
import boulangerie.model.Adresse;
import boulangerie.model.Employe;
import boulangerie.service.EmployeService;

@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
public class EmployeServiceTest {

	@Autowired
	EmployeService employeSrv;

	Adresse adresse = new Adresse();
	@Test
	void testCreate() {
		String login = new String("login@mail.com");
		Employe employe = new Employe(login, "abc","nom","prenom", adresse);
		employeSrv.create(employe);
		assertNotNull(employeSrv.findById(employe.getId()));
		assertThrows(EmployeException.class, () -> {
			employeSrv.create(new Employe());
		});
	}
	
	@Test
	void testUpdate() {
		String login = new String("login@mail.com");
		Employe employe = new Employe(login, "abc","nom","prenom", adresse);
		employeSrv.create(employe);
		employeSrv.update(employe);
		employe = employeSrv.findById(employe.getId());
		
	}

	@Test
	void testFindAll() {
		assertTrue(employeSrv.findAll().isEmpty());
		String login = new String("login@mail.com");
		Employe employe = new Employe(login, "abc","nom","prenom", adresse);
		employeSrv.create(employe);

		assertEquals(1, employeSrv.findAll().size());

	}

	@Test
	void testDeleteEmploye() {
		String login = new String("login@mail.com");
		Employe employe = new Employe(login, "abc","nom","prenom", adresse);
		employeSrv.create(employe);
		employeSrv.delete(employe);
		assertThrows(EmployeException.class, () -> {
			employeSrv.findById(employe.getId());
		});
	}

	@Test
	void testDeleteInteger() {
		String login = new String("login@mail.com");
		Employe employe = new Employe(login, "abc","nom","prenom", adresse);
		employeSrv.create(employe);
		employeSrv.delete(employe.getId());
		assertThrows(EmployeException.class, () -> {
			employeSrv.findById(employe.getId());
		});
	}
	
}
