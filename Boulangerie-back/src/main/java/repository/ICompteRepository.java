package repository;

import java.util.List;

import model.Client;
import model.Compte;
import model.Employe;

public interface ICompteRepository extends IRepository<Compte,Integer> {

	Compte findByEmailAndPassword(String email,String password);
	List<Employe> findAllEmploye();
	List<Client> findAllClient();
	
	Employe findEmployeById(Integer id);
	Client findClientById(Integer id);
	
	
	Client findClientByIdWithArticlesFavoris(Integer id);

}
