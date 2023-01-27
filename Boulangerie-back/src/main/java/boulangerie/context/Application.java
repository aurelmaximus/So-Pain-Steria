package boulangerie.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import repository.jpa.CommandeRepository;
import repository.jpa.CompteRepository;
import repository.jpa.IngredientRepositoryJpa;
import repository.jpa.ProduitRepositoryJpa;

public class Application {

	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("boulangerie");
	private CommandeRepository commandeRepo = new CommandeRepository();
	private IngredientRepositoryJpa ingredientRepo = new IngredientRepositoryJpa();
	private ProduitRepositoryJpa produitRepo = new ProduitRepositoryJpa();
	private CompteRepository compteRepo = new CompteRepository();

	//private static Application instance;



	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public CommandeRepository getCommandeRepo() {
		return commandeRepo;
	}

	public void setCommandeRepo(CommandeRepository commandeRepo) {
		this.commandeRepo = commandeRepo;
	}

	public IngredientRepositoryJpa getIngredientRepo() {
		return ingredientRepo;
	}

	public void setIngredientRepo(IngredientRepositoryJpa ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	public ProduitRepositoryJpa getProduitRepo() {
		return produitRepo;
	}

	public void setProduitRepo(ProduitRepositoryJpa produitRepo) {
		this.produitRepo = produitRepo;
	}

	public CompteRepository getCompteRepo() {
		return compteRepo;
	}

	public void setCompteRepo(CompteRepository compteRepo) {
		this.compteRepo = compteRepo;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}




	}
