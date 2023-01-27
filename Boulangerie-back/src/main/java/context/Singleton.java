package context;

import repository.jdbc.DAOCommande;
import repository.jdbc.DAOCompte;
import repository.jdbc.DAOIngredient;
import repository.jdbc.DAOProduit;

public class Singleton {

	private DAOCommande daoCommande = new DAOCommande();
	private DAOCompte daoCompte = new DAOCompte();
	private DAOIngredient daoIngredient = new DAOIngredient();
	private DAOProduit daoProduit = new DAOProduit();
	private static Singleton instance;
	
	
	
	public static Singleton getInstance() 
	{
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}



	public DAOCommande getDaoCommande() {
		return daoCommande;
	}



	public void setDaoCommande(DAOCommande daoCommande) {
		this.daoCommande = daoCommande;
	}



	public DAOCompte getDaoCompte() {
		return daoCompte;
	}



	public void setDaoCompte(DAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}



	public DAOIngredient getDaoIngredient() {
		return daoIngredient;
	}



	public void setDaoIngredient(DAOIngredient daoIngredien) {
		this.daoIngredient = daoIngredien;
	}



	public DAOProduit getDaoProduit() {
		return daoProduit;
	}



	public void setDaoProduit(DAOProduit daoProduit) {
		this.daoProduit = daoProduit;
	}



	
	
}
