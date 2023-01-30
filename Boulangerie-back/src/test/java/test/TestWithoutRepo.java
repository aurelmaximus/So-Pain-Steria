package test;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.ArticleFavoris;
import model.Basique;
import model.Categorie;
import model.Client;
import model.Commande;
import model.Elabore;
import model.Employe;
import model.EtatCommande;
import model.Ingredient;
import model.LigneCommande;
import model.LigneIngredient;
import model.SansCompte;


public class TestWithoutRepo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopain_steria");
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
		
		
			
			Ingredient ingredient1 = new Ingredient ("Farine_T55",true);		
			em.persist(ingredient1);
			
			Ingredient ingredient2 = new Ingredient ("Beurre",true);		
			em.persist(ingredient2);
			
			Ingredient ingredient3 = new Ingredient ("Oeuf",true);		
			em.persist(ingredient3);
			
			Ingredient ingredient4 = new Ingredient ("Sucre",false);		
			em.persist(ingredient4);
			
			Ingredient ingredient5 = new Ingredient ("Framboise",false);		
			em.persist(ingredient5);
		
			
			Basique basique1 = new Basique (2.80,"Religieuse",Categorie.Viennoiserie);
			em.persist(basique1);
			
			Basique basique2 = new Basique (2.70,"Eclair",Categorie.Viennoiserie);
			em.persist(basique2);
			
			
			Elabore elobore1 = new Elabore (22,"Fraisier",6);
			em.persist(elobore1);
			
			Elabore elobore2 = new Elabore (25,"Tarte_Framboise",4);
			em.persist(elobore2);
			
			
			
			Commande commande1 = new Commande (LocalDate.parse("2023-01-27"), LocalTime.parse("16:55"),EtatCommande.EnCours,false);
			em.persist(commande1);
			
			Commande commande2 = new Commande (LocalDate.parse("2023-01-27"), LocalTime.parse("17:10"),EtatCommande.Termine,false);
			em.persist(commande2);
			
			
			Adresse adresse1 = new Adresse ("1","Rue de la victoire","Bordeaux","33000");
			Client client1 = new Client("prune.pommier@gmail.com","peche","prune","pommier",adresse1);
			em.persist(client1);
			
			
			Adresse adresse2 = new Adresse ("2","Rue de Pelegrin","Bordeaux","33000");
			Client client2 = new Client("bb","bb","bb","cc",adresse2);
			em.persist(client2);
			
			Adresse adresse3 = new Adresse ("3","Avenue Victor Hugo","Paris","75000");
			Employe employe1 = new Employe("cc","cc","cc","dd",adresse3);
			em.persist(employe1);
			
			Adresse adresse4 = new Adresse ("4","Rue de la Castelane","Marseille","13000");
			Employe employe2 = new Employe("ee","ee","ee","ff",adresse4);
			em.persist(employe2);
			
			
			SansCompte client3 = new SansCompte("gg","hh","ii");
			client3.setCommande(commande1);
			em.persist(client3);
			
			ArticleFavoris favoris1 = new ArticleFavoris ();
			favoris1.setClient(client1);
			favoris1.setProduit(elobore1);
			em.persist(favoris1);
			
			ArticleFavoris favoris2 = new ArticleFavoris ();
			favoris2.setClient(client1);
			favoris2.setProduit(elobore2);
			em.persist(favoris2);
			
			
			LigneCommande lc1 = new LigneCommande (2,6.00);
			lc1.setCommande(commande1);
			lc1.setProduit(elobore1);
			em.persist(lc1);
			
	
			LigneIngredient li1 = new LigneIngredient ();		
			li1.setIngredient(ingredient4);
			li1.setProduit(elobore1);
			em.persist(li1);
			
			LigneIngredient li2 = new LigneIngredient ();		
			li2.setIngredient(ingredient3);
			li2.setProduit(elobore1);
			em.persist(li2);
		
			
		
			tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			} finally {
				if (em != null) {
					em.close();
				}
			}

			emf.close();

		
	}

}
