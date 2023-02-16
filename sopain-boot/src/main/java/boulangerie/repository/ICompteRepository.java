//package boulangerie.repository;
//
//import java.util.List;
//
//import boulangerie.model.Client;
//import boulangerie.model.Compte;
//import boulangerie.model.Employe;
//
//public interface ICompteRepository extends IRepository<Compte,Integer> {
//
//	Compte findByEmailAndPassword(String email,String password);
//	List<Employe> findAllEmploye();
//	List<Client> findAllClient();
//	
//	Employe findEmployeById(Integer id);
//	Client findClientById(Integer id);
//	
//	
//	Client findClientByIdWithArticlesFavoris(Integer id);
//
//}
