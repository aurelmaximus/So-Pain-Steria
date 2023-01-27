package repository.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Commande;
import model.Ingredient;
import repository.IRepository;

public class DAOCommande implements IDAOCommande {

	@Override
	public Commande findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Commande o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Commande o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}