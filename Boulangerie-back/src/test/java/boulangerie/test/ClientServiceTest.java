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
import boulangerie.exception.ClientException;
import boulangerie.model.Adresse;
import boulangerie.model.Client;
import boulangerie.service.ClientService;

@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
public class ClientServiceTest {
	
	@Autowired
	ClientService clientSrv;

	Adresse adresse = new Adresse();
	@Test
	void testCreate() {
		String email = new String("email@mail.com");
		Client client = new Client(email, "abc","nom","prenom", adresse);
		clientSrv.create(client);
		assertNotNull(clientSrv.findById(client.getId()));
		assertThrows(ClientException.class, () -> {
			clientSrv.create(new Client());
		});
	}
	
	@Test
	void testUpdate() {
		String email = new String("email@mail.com");
		Client client = new Client(email, "abc","nom","prenom", adresse);
		clientSrv.create(client);
		clientSrv.update(client);
		client = clientSrv.findById(client.getId());
		
	}

	@Test
	void testFindAll() {
		assertTrue(clientSrv.findAll().isEmpty());
		String email = new String("email@mail.com");
		Client client = new Client(email, "abc","nom","prenom", adresse);
		clientSrv.create(client);

		assertEquals(1, clientSrv.findAll().size());

	}

	@Test
	void testDeleteClient() {
		String email = new String("email@mail.com");
		Client client = new Client(email, "abc","nom","prenom", adresse);
		clientSrv.create(client);
		clientSrv.delete(client);
		assertThrows(ClientException.class, () -> {
			clientSrv.findById(client.getId());
		});
	}

	@Test
	void testDeleteInteger() {
		String email = new String("email@mail.com");
		Client client = new Client(email, "abc","nom","prenom", adresse);
		clientSrv.create(client);
		clientSrv.delete(client.getId());
		assertThrows(ClientException.class, () -> {
			clientSrv.findById(client.getId());
		});
	}

}

