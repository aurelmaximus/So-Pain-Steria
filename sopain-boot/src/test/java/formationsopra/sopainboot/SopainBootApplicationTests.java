package formationsopra.sopainboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import boulangerie.model.Adresse;
import boulangerie.model.Client;
import boulangerie.model.Employe;
import boulangerie.repository.ClientRepository;
import boulangerie.repository.EmployeRepository;


@SpringBootTest
class SopainBootApplicationTests {
	
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private EmployeRepository employeRepo;

	@Test
	void contextLoads() {
		
		Client jeanjacques = new Client("jean@jacques@gmail.com",
				"c123","De Labouche",
				"Jean-Jacques",
				new Adresse("12", "Rue des Papayes", "Ouiouiville", "112234"));
		
		jeanjacques = clientRepo.save(jeanjacques);
		
		Client jeannine = new Client("jeannine@jacques@gmail.com",
				"c123","Dupalais",
				"Jeannine",
				new Adresse("50", "Rue des Kiwis", "Wawaville", "112234"));
		
		jeannine = clientRepo.save(jeannine);
		
		Employe vendeur1 = new Employe("vendeur1@sopain.com",
				"e123","Dupain",
				"Thierry",
				new Adresse("1", "Rue du Pain", "Sopainville", "112234"));
		

		vendeur1 = employeRepo.save(vendeur1);
		
		
		Employe vendeur2 = new Employe("vendeur2@sopain.com",
				"e123","De Labrioche",
				"Marion",
				new Adresse("1", "Rue du Pain", "Sopainville", "112234"));
		
		vendeur2 = employeRepo.save(vendeur2);
	
	
	
	}

}
