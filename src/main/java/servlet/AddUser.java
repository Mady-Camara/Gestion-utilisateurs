package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UserDao;
import metier.UserMetier;

/**
 * @Author Mady-Camara
 */
@WebServlet("/add")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/ajouterUtilisateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> messagesErreur = UserMetier.validation(request);
		if(messagesErreur.isEmpty()) {
			UserDao.ajouter(new Utilisateur(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("login"), request.getParameter("password")));
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("messages", messagesErreur);
			getServletContext().getRequestDispatcher("/WEB-INF/ajouterUtilisateur.jsp").forward(request, response);
		}
	}

}
