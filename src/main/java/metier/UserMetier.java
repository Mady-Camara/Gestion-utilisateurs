package metier;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Mady-Camara
 */
public class UserMetier {
	private static final String ERR_NULL = "Les champs doivent etre renseigner";
	private static final String ERR_NUMERIC = "Pas de caracteres numeriques pour nom et prenom";
	private static final String ERR_TAILLE_NOM = "La taille du nom doit etre superieure a 1 et inferieur a 50";
	private static final String ERR_TAILLE_PRENOM = "La taille du prenom doit etre superieure a 2 et inferieur a 50";
	private static final String ERR_TAILLE_LOGIN = "La taille du login doit etre superieure a 4 et inferieur a 50";
	private static final String ERR_TAILLE_PASSWORD = "La taille du login doit etre superieure a 4 et inferieur a 50";
	
	public static List<String> validation(HttpServletRequest request) {
		List<String> messagesErreur = new ArrayList<String>();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		boolean isNull = false;
		boolean isNumeric = false;
		
		if(nom == null || nom.equals("")) {
			messagesErreur.add(ERR_NULL);
			isNull = true;
		}
		else if(nom.length() < 0 || nom.length() > 50) {
			messagesErreur.add(ERR_TAILLE_NOM);
		}
		else if(!nom.matches("[a-zA-Z]+")) {
			messagesErreur.add(ERR_NUMERIC);
			isNumeric = true;
		}

		if(prenom == null || prenom.equals("")) {
			if(!isNull) {
				messagesErreur.add(ERR_NULL);
				isNull = true;
			}
		}
		else if(prenom.length() < 0 || prenom.length() > 50) {
			messagesErreur.add(ERR_TAILLE_PRENOM);
		}
		else if(!prenom.matches("[a-zA-Z]+")) {
			if(!isNumeric) {
				messagesErreur.add(ERR_NUMERIC);
				isNumeric = true;
			}
		}

		if(login == null || login.equals("")) {
			if(!isNull) {
				messagesErreur.add(ERR_NULL);
				isNull = true;
			}
		}
		else if(login.length() < 4 || login.length() > 50) {
			messagesErreur.add(ERR_TAILLE_LOGIN);
		}
		
		if(password == null || password.equals("")) {
			if(!isNull) {
				messagesErreur.add(ERR_NULL);
				isNull = true;
			}
		}
		else if(password.length() < 0 || password.length() > 50) {
			messagesErreur.add(ERR_TAILLE_PASSWORD);
		}
		
		return messagesErreur;
	}
}
