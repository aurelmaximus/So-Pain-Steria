package boulangerie.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import repository.jpa.IngredientRepositoryJpa;
import repository.IIngredientRepository;

import repository.jpa.ProduitRepositoryJpa;
import repository.IProduitRepository;

public class Application {

	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("quest");
	//private DAOCommande daoCommande = new DAOCommande();
	//private DAOCompte daoCompte = new DAOCompte();
	private IngredientRepositoryJpa IngredientRepo = new IngredientRepositoryJpa();
	private ProduitRepositoryJpa ProduitRepo = new ProduitRepositoryJpa();
	//private static Application instance;



	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public IngredientRepositoryJpa getIngredientRepo() {
		return IngredientRepo;
	}

	public void setIngredientRepo(IngredientRepositoryJpa ingredientRepo) {
		IngredientRepo = ingredientRepo;
	}

	public ProduitRepositoryJpa getProduitRepo() {
		return ProduitRepo;
	}

	public void setProduitRepo(ProduitRepositoryJpa produitRepo) {
		ProduitRepo = produitRepo;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}



	}
