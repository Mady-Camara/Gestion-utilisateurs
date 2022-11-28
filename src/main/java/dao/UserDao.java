package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Utilisateur;

public class UserDao {
	private static final String INSERT_USER = "INSERT INTO Utilisateur (nom, prenom, login, password) VALUES (?, ?, ?, ?);";
	private static final String DELETE_USER = "DELETE FROM Utilisateur WHERE id = ?;";
	private static final String UPDATE_USER = "UPDATE Utilisateur set nom = ?, prenom = ?, login = ?, password = ? where id = ?;";
	private static final String ALL_USER = "SELECT * Utilisateur;";
	private static final String GET_USER = "SELECT id, nom, prenom, login, password FROM Utilisateur WHERE id =?";
	private static final String GET_USER_AUTH = "SELECT id, nom, prenom, login, password FROM Utilisateur WHERE login = ? AND password = ?";
	
	
	public static Connection connexion() {
		 Connection conn = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gesusers", "postgres", "passer");
	         //Statement statement = conn.createStatement();
	         return conn;
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
		return null;
	}
	
	public static boolean ajouter(Utilisateur utilisateur) {
		try {
			Connection conn = connexion();
			PreparedStatement preparedInsertStatement = conn.prepareStatement(INSERT_USER);
			preparedInsertStatement.setString(1, utilisateur.getNom());
			preparedInsertStatement.setString(2, utilisateur.getPrenom());
			preparedInsertStatement.setString(3, utilisateur.getLogin());
			preparedInsertStatement.setString(4, utilisateur.getPassword());
		    preparedInsertStatement.executeUpdate();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static List<Utilisateur> lister(){
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			Connection conn = connexion();
			PreparedStatement preparedSelectStatement = conn.prepareStatement(ALL_USER);
			ResultSet rs = preparedSelectStatement.executeQuery();
			System.out.println("============================ Liste ==========================");
			while (rs.next()) {
                utilisateurs.add(new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password")));
                System.out.println(rs.getString("nom")+" "+rs.getString("prenom"));
            }
		}
		catch(Exception e) {
			return null;
		}
		return utilisateurs;
	}
	
	public static Utilisateur get(long id)  {
		
		try {
			Connection conn = connexion();
			PreparedStatement preparedStatement = conn.prepareStatement(GET_USER);
	        preparedStatement.setLong(1, id);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	return new Utilisateur(rs.getLong("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"));
	        }
	            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Utilisateur authentification(String login, String password)  {
		
		try {
			Connection conn = connexion();
			PreparedStatement preparedStatement = conn.prepareStatement(GET_USER_AUTH);
	        preparedStatement.setString(1, login);
	        preparedStatement.setString(2, password);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	return new Utilisateur(rs.getLong("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"));
	        }
	            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean modifier(Utilisateur user) {
		List<Utilisateur> utilisateurs = lister();
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == user.getId()) {
				try {
					Connection conn = connexion();
					PreparedStatement preparedUpdateStatement = conn.prepareStatement(UPDATE_USER);
					preparedUpdateStatement.setString(1, user.getNom());
					preparedUpdateStatement.setString(2, user.getPrenom());
					preparedUpdateStatement.setString(3, user.getLogin());
					preparedUpdateStatement.setString(4, user.getPassword());
					preparedUpdateStatement.setLong(5, user.getId());
					preparedUpdateStatement.executeUpdate();
				}
				catch(Exception e) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static boolean supprimer(long id) {
		List<Utilisateur> utilisateurs = lister();
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == id) {
				try {
					Connection conn = connexion();
					PreparedStatement preparedDeletetStatement = conn.prepareStatement(DELETE_USER);
					preparedDeletetStatement.setLong(5, id);
					preparedDeletetStatement.executeUpdate();
				}
				catch(Exception e) {
					return false;
				}
			}
		}
		return true;
	}
}
