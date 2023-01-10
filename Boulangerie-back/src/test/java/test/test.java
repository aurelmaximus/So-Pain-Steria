package test;



import model.Adresse;
import model.Boissons;
import model.Commande;
import model.Client;
import model.Compte;
import model.Employe;
import model.Gateaux;
import model.Matiere_Premiere;
import model.Metier;
import model.Pain;
import model.Ingredient;
import model.Viennoiseries;




public class test {

	
	public static void demo() 
	{
		
		Adresse a1 = new Adresse ("19","Rue des fleurs","Bordeaux","33000");
		Adresse a2 = new Adresse ("18","Rue des fleurs","Bordeaux","33000");
		
		Client c1 = new Client("Aurel","Aurel","Aurélien","Bulme",a1);
		
		Employe emp1 = new Employe("emp1","emp1","Rouxel","Julien",a2,Metier.Boulanger);
		Employe emp2 = new Employe("emp2","emp2","Axus","Arthur",a2,Metier.Patissier);
		Employe emp3 = new Employe("emp2","emp2","Sabau","Romain",a2,Metier.Serveur);
		
		System.out.println(a1);
		System.out.println(c1);
		System.out.println(emp1);

	
		
	
		
		
	}
	
	
	public static void main(String[] args) {
		
		Commande.Commande();
		
	}

}
