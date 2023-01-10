package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Adresse;
import model.Compte;
import model.Employe;
import model.Ingredient;
import model.Metier;

public class DAOIngredient implements IDAO<Ingredient, Integer> {

	
	public Ingredient findById(Integer id) {
		
		Ingredient i = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ingredient where id=? ");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{

			i = new Ingredient ((Integer)rs.getInt("id"), rs.getString("libelle"),rs.getInt("qte"),rs.getBoolean("allergene"));
				
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
	}

	
	@Override
	public List<Ingredient> findAll() {
		
		List<Ingredient> ingredient = new ArrayList();
		Ingredient i = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ingredient");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
			i = new Ingredient ((Integer)rs.getInt("id"), rs.getString("libelle"),rs.getInt("qte"),rs.getBoolean("allergene"));
			ingredient.add(i);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ingredient;
		
	}

	
	@Override 
	public void insert(Ingredient i) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ingredient (id,libelle,qte,allergene) VALUES(?,?,?,?)");
			
			ps.setInt(1, i.getId());
			ps.setString(2, i.getLibelle());
			ps.setInt(3, i.getQte());
			ps.setBoolean(4, i.isAllergene());
		

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}


	}

	
	@Override
	public void update(Ingredient i) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("Update ingredient set libelle=?, qte=?, allerge=? where id=?");

			ps.setString(1, i.getLibelle());
			ps.setInt(2, i.getQte());
			ps.setBoolean(3, i.isAllergene());
			ps.setInt(4, i.getId());
			
			ps.executeUpdate();
			ps.close();

			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE from Ingredient where id=?");

			ps.setInt(1,id);
			ps.executeUpdate();


			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
}
