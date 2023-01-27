package repository.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.Ingredient;
import model.Produit;
import repository.IRepository;

public class DAOProduit implements IRepository<Produit, Integer>{


	public Produit findById(Integer id) {
	
		Produit p = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Produit where id=? ");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{

			p = new Produit ((Integer)rs.getInt("id"),rs.getDouble("prix"), rs.getInt("stock"),rs.getString("libelle"));
				
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return p;
	}
	
	
	public List<Produit> findAll(){
	
	List<Produit> produit = new ArrayList();
	Produit p = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Produit");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
			p = new Produit ((Integer)rs.getInt("id"),rs.getDouble("prix"), rs.getInt("stock"),rs.getString("libelle"));
			produit.add(p);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return produit;
		
	}

	
	public void insert(Produit p) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO Produit (id,prix,stock,libelle) VALUES(?,?,?,?)");
			
			ps.setInt(1, p.getId());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getStock());
			ps.setString(4, p.getLibelle());
		

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	
	public void update(Produit p) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("Update Produit set  prix=?, stock=?, libelle=? where id=?");

			ps.setDouble(1, p.getPrix());
			ps.setInt(2, p.getStock());
			ps.setString(3, p.getLibelle());
			ps.setInt(4, p.getId());
			
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

			PreparedStatement ps = conn.prepareStatement("DELETE from Produit where id=?");

			ps.setInt(1,id);
			ps.executeUpdate();


			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
		
}
	
	