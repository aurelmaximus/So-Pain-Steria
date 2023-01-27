package repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Adresse;
import model.Compte;
import model.Employe;
import model.Metier;
import repository.IRepository;

public class DAOCompte implements IRepository<Compte, Integer> {

	public Compte findById(Integer id) {

		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte where id=? ");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				if (rs.getString("type_compte").equals("Employe")) {
					Adresse adresse = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"),
							rs.getString("cp"));
					c = new Employe((Integer) rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"), adresse,
							Metier.valueOf(rs.getString("metier")));
				}

				else {
					Adresse adresse = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"),
							rs.getString("cp"));
					c = new Employe((Integer) rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"), adresse,
							Metier.valueOf(rs.getString("metier")));
				}

			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}


	public Compte seConnecter(String login, String password) {

		DAOCompte DAOc = new DAOCompte();
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				if (rs.getString("type_compte").equals("Employe")) {
					Adresse adresse = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"),
							rs.getString("cp"));
					c = new Employe((Integer) rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"), adresse,
							Metier.valueOf(rs.getString("metier")));
				}

				else {
					Adresse adresse = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"),
							rs.getString("cp"));
					c = new Employe((Integer) rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"), adresse,
							Metier.valueOf(rs.getString("metier")));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return c;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Compte c) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,nom,prenom,numero,voie,ville,cp,type_compte,metier) VALUES(?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getNom());
			ps.setString(4, c.getPrenom());
			ps.setString(5, c.getAdresse().getNumero());
			ps.setString(6, c.getAdresse().getVoie());
			ps.setString(7, c.getAdresse().getVille());
			ps.setString(8, c.getAdresse().getCp());
			ps.setString(9, c.getClass().getSimpleName());
			
			if (c instanceof Employe) {
				ps.setString(10, ((Employe) c).getMetier().toString());
			} else {
				ps.setString(10, null);
			}

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void update(Compte o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE from compte where id=?");

			ps.setInt(1,id);
			ps.executeUpdate();


			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
