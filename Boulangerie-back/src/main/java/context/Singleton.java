package context;

import dao.DAOCommande;
import dao.DAOCompte;
import dao.DAOIngredient;
import dao.DAOProduit;

public class Singleton {

	private DAOCommande daoMCommande = new DAOCommande();
	private DAOCompte daoCompte = new DAOCompte();
	private DAOIngredient daoIngredien = new DAOIngredient();
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



	public DAOCommande getDaoMCommande() {
		return daoMCommande;
	}



	public void setDaoMCommande(DAOCommande daoMCommande) {
		this.daoMCommande = daoMCommande;
	}



	public DAOCompte getDaoCompte() {
		return daoCompte;
	}



	public void setDaoCompte(DAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}



	public DAOIngredient getDaoIngredien() {
		return daoIngredien;
	}



	public void setDaoIngredien(DAOIngredient daoIngredien) {
		this.daoIngredien = daoIngredien;
	}



	public DAOProduit getDaoProduit() {
		return daoProduit;
	}



	public void setDaoProduit(DAOProduit daoProduit) {
		this.daoProduit = daoProduit;
	}
	
	

	
	
}
