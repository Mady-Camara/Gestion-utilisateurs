package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Utilisateur;

public class UtilisateurDao {
	private static List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	private static long lastId = 1L;
	
	static {
		UtilisateurDao.ajouter(new Utilisateur("CAMARA", "Mady", "Mady-Camara", "passer"));
		UtilisateurDao.ajouter(new Utilisateur("TOURE", "Hamsa", "Hamsa-TOURE", "passer"));
		UtilisateurDao.ajouter(new Utilisateur("TRAORE", "Karamoko", "Karamoko-Camara", "passer"));
	}
	
	public static void ajouter(Utilisateur utilisateur) {
		utilisateur.setId(lastId++);
		utilisateurs.add(utilisateur);
	}
	
	public static List<Utilisateur> lister(){
		return utilisateurs;
	}
	
	public static Utilisateur get(long id) {
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == id) {
				return utilisateur;
			}
		}
		return null;
	}
	
	public static boolean modifier(Utilisateur user) {
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == user.getId()) {
				utilisateur.setNom(user.getNom());
				utilisateur.setPrenom(user.getPrenom());
				utilisateur.setLogin(user.getLogin());
				utilisateur.setPassword(user.getPassword());
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean supprimer(long id) {
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == id) {
				utilisateurs.remove(utilisateur);
				return true;
			}
		}
		return false;
	}
	
}