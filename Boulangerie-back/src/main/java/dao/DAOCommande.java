package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Commande;

public class DAOCommande implements IDAO<Commande, Integer> {

	@Override
	public Commande findById(Integer numero) {
		Commande c=null;
		//DAOPatient DAOp= new DAOPatient();
		//DAOCompte DAOm= new DAOCompte();	

		//Commande(Integer numero, Client client, LocalTime heure, LocalTime minute,boolean termine )
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM commande where numero=? ");
			ps.setInt(1, numero);


			ResultSet rs =   ps.executeQuery();
			while(rs.next()) {
				Client client = new Client();
				c=new Commande(rs.getInt("id"),client,LocalTime.parse(rs.getString("heure")),LocalTime.parse(rs.getString("minute")),rs.getBoolean("termine"));
				//Patient patient= (Patient)DAOp.findById(rs.getInt("id_patient"));
				//Medecin medecin= (Medecin)DAOm.findById(rs.getInt("id_medecin"));
				//v = new Visite(rs.getInt("id"), patient, medecin,rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")),rs.getInt("prix"));
				}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}
	
	public List<Commande> findByIdClient(Integer id) {
		List<Commande> commandes = new ArrayList();
		return commandes;
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
	
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE from commande where id=?");

			ps.setInt(1,id);
			ps.executeUpdate();


			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
