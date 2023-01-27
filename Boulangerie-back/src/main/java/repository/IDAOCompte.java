package repository;

import model.Compte;

public interface IDAOCompte extends IRepository<Compte,Integer> {

	public Compte findByLoginAndPassword(String login,String password);
}
