package metier;

import javax.servlet.http.HttpServletRequest;

public class UserMetier {
	private static final String ERR_NULL = "Le champs doit etre renserigner";
	private static final String ERR_NUMERIC = "Pas de caracteres numeriques";
	private static final String ERR_TAILLE_NOM = "La taille du nom doit etre superieure a 1 et inferieur a 50";
	private static final String ERR_TAILLE_PRENOM = "La taille du prenom doit etre superieure a 2 et inferieur a 50";
	private static final String ERR_TAILLE_LOGIN = "La taille du login doit etre superieure a 4 et inferieur a 50";
	private static final String ERR_TAILLE_PASSWORD = "La taille du login doit etre superieure a 4 et inferieur a 50";
	
	public static String validationNom(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		if(nom == null || nom.equals("")) {
			return ERR_NULL;
		}
		else if(nom.length() < 0 || nom.length() > 50) {
			return ERR_TAILLE_NOM;
		}
		else if(!nom.matches("[a-zA-Z]+")) {
			return ERR_NUMERIC;
		}
		
		return null;
	}
	
	public static String validationPrenom(HttpServletRequest request) {
		String prenom = request.getParameter("prenom");
		if(prenom == null || prenom.equals("")) {
			return ERR_NULL;
		}
		else if(prenom.length() < 0 || prenom.length() > 50) {
			return ERR_TAILLE_PRENOM;
		}
		else if(!prenom.matches("[a-zA-Z]+")) {
			return ERR_NUMERIC;
		}
		
		return null;
	}
	
	public static String validationLogin(HttpServletRequest request) {
		String login = request.getParameter("login");
		if(login == null || login.equals("")) {
			return ERR_NULL;
		}
		else if(login.length() < 4 || login.length() > 50) {
			return ERR_TAILLE_LOGIN;
		}
		
		return null;
	}
	
	public static String validationPassword(HttpServletRequest request) {
		String password = request.getParameter("password");
		if(password == null || password.equals("")) {
			return ERR_NULL;
		}
		else if(password.length() < 0 || password.length() > 50) {
			return ERR_TAILLE_PASSWORD;
		}
		
		return null;
	}
}
