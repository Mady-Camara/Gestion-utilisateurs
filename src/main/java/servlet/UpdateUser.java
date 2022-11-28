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
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("utilisateur", UserDao.get(Long.parseLong(request.getParameter("id"))));
		getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> messagesErreur = UserMetier.validation(request);
		if(messagesErreur.isEmpty()) {
			UserDao.modifier(new Utilisateur(Long.parseLong(request.getParameter("id")) ,request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("login"), request.getParameter("password")));
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("messages", messagesErreur);
			getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateur.jsp").forward(request, response);
		}
	}

}
