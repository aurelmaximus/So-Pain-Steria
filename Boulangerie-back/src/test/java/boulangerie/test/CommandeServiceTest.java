package boulangerie.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import boulangerie.config.AppConfig;
import boulangerie.exception.CommandeException;
import boulangerie.model.Commande;
import boulangerie.model.EtatCommande;
import boulangerie.service.CommandeService;



@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
class CommandeServiceTest {
	@Autowired
	CommandeService commandeSrv;

	@Test
	void testCreate() {
		Commande commande = new Commande(LocalDate.of(2022, 01, 10),LocalTime.of(12,33),EtatCommande.EnCours,true);
		commandeSrv.create(commande);
		assertNotNull(commandeSrv.findById(commande.getNumero()));
		assertThrows(CommandeException.class, () -> {
			commandeSrv.create(new Commande());
		});
	}

	@Test
	void testUpdate() {
		Commande commande = new Commande(LocalDate.of(2022, 02, 10),LocalTime.of(12,33),EtatCommande.Prete,true);
		commandeSrv.create(commande);
		commande.setEtatcommande(EtatCommande.Termine);
		commande.setHeureArrive(LocalTime.of(23, 30));
		commandeSrv.update(commande);
		commande = commandeSrv.findById(commande.getNumero());
		assertEquals(EtatCommande.Termine, commande.getEtatcommande());
		assertEquals(LocalTime.of(23, 30), commande.getHeureArrive());
		// ...mettre les autres assertEquals pour l'adresse
		assertEquals(LocalDate.of(2022, 02, 10), commande.getDateArrivee());

	}

	@Test
	void testFindAll() {
		assertTrue(commandeSrv.findAll().isEmpty());
		Commande commande = new Commande(LocalDate.of(2022, 02, 10),LocalTime.of(12,33),EtatCommande.Prete,true);
		commandeSrv.create(commande);

		assertEquals(1, commandeSrv.findAll().size());

	}

	@Test
	void testDeleteFormateur() {
		Commande commande = new Commande(LocalDate.of(2022, 02, 10),LocalTime.of(12,33),EtatCommande.Prete,true);
		commandeSrv.create(commande);
		commandeSrv.delete(commande);
		assertThrows(CommandeException.class, () -> {
			commandeSrv.findById(commande.getNumero());
		});
	}

	@Test
	void testDeleteInteger() {
		Commande commande = new Commande(LocalDate.of(2022, 02, 10),LocalTime.of(12,33),EtatCommande.Prete,true);
		commandeSrv.create(commande);
		commandeSrv.delete(commande.getNumero());
		assertThrows(CommandeException.class, () -> {
			commandeSrv.findById(commande.getNumero());
		});
	}

}
