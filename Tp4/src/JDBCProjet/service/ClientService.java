package JDBCProjet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBCProjet.beans.Client;
import JDBCProjet.connexion.Connexion;
import JDBCProjet.dao.IDao;

public class ClientService implements IDao<Client> {

	@Override
	public boolean create(Client o) {
		PreparedStatement stmt;
		try {
		 stmt = Connexion.getconn().prepareStatement("INSERT INTO client (nom, prenom) VALUES (?, ?)");
		
		 
		 stmt.setString(1, o.getNom());
		 stmt.setString(2, o.getPrenom());
		 return stmt.execute();
			 }
			 catch (SQLException e) {
					System.err.println("Error creating SQL statement: "+e.getMessage());
					 System.err.println("Error executing query: " +e.getMessage());
					 return false;
					}
			
		
	}

	@Override
	public List<Client> findAll() {
		Statement stmt;
		ArrayList<Client> l=new ArrayList<Client>();
		try {
			stmt = Connexion.getconn().createStatement();
			String query = "SELECT * FROM Client;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				l.add(new Client (rs.getInt(1),rs.getString(2),rs.getString(3)));

				

			}
			
			 return l ;
			 }
			catch (SQLException e) {
				System.err.println("Error executing query: " +e.getMessage());
				System.err.println("Error creating SQL statement: "+e.getMessage());
				return null;}

			
			 
		 
				
	}

	@Override
	public Client findById(int id) {
		PreparedStatement stmt;
		try {
		 stmt = Connexion.getconn().prepareStatement("SELECT * FROM Client WHERE id=?");
		 stmt.setInt(1, id);
		 ResultSet rs = stmt.executeQuery();

			rs.next();	

			return new Client(rs.getInt(1),rs.getString(2),rs.getString(3));}
		
			 catch (SQLException e) {
					System.err.println("Error creating SQL statement: "+e.getMessage());
					 System.err.println("Error executing query: " +e.getMessage());
					 return null;
					}
	}

	@Override
	public boolean delete(Client o) {
		PreparedStatement stmt;
		try {
		 stmt = Connexion.getconn().prepareStatement("DELETE FROM client WHERE id=?");
		
		 
		 stmt.setInt(1, o.getId());
		  stmt.execute();
		  return stmt.getUpdateCount()>0;
			 }
			 catch (SQLException e) {
					System.err.println("Error creating SQL statement: "+e.getMessage());
					 System.err.println("Error executing query: " +e.getMessage());
					 return false;
					}
			
		
	
	}

	@Override
	public boolean update(Client o) {
		PreparedStatement stmt;
		try {
		 stmt = Connexion.getconn().prepareStatement("Update Client set nom = ? , prenom = ? where id = ?");
		
		 
		 stmt.setString(1, o.getNom());
		 stmt.setString(2, o.getPrenom());
		 stmt.setInt(3, o.getId());
		 return stmt.executeUpdate()>0;
			 }
			 catch (SQLException e) {
					System.err.println("Error creating SQL statement: "+e.getMessage());
					 System.err.println("Error executing query: " +e.getMessage());
					 return false;
					}
	}}		
	


