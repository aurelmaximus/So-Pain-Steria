package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.Client;
import model.Employe;


public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop");

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
		
			//Commande
			
			//ArticleFavoris
			
		
			Adresse adresse1 = new Adresse ("1","Rue de la victoire","Bordeaux","33000");
			Client client1 = new Client("aa","aa","aa","bb",adresse1);
			em.persist(client1);
			
			Adresse adresse2 = new Adresse ("2","Rue de Pelegrin","Bordeaux","33000");
			Client client2 = new Client("bb","bb","bb","cc",adresse2);
			em.persist(client2);
			
			

			Employe employe1 = new Employe("bb","bb","bb","cc",adresse3);
			
			
			Employe employe2 = new Employe("bb","bb","bb","cc",adresse4);
			
			
			
			
		
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
