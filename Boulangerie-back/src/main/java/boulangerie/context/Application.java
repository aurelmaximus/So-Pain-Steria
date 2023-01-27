package boulangerie.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Application {

	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("quest");
	//private DAOCommande daoCommande = new DAOCommande();
	//private DAOCompte daoCompte = new DAOCompte();
	//private DAOIngredient daoIngredient = new DAOIngredient();
	//private DAOProduit daoProduit = new DAOProduit();
	//private static Application instance;



	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}
}


