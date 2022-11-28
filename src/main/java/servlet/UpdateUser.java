package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UserDao;
import dao.UtilisateurDao;

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
		if(request.getParameter("login") != null || request.getParameter("prenom") != null || request.getParameter("nom") != null || request.getParameter("password") != null) {
			UserDao.modifier(new Utilisateur(Long.parseLong(request.getParameter("id")) ,request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("login"), request.getParameter("password")));
		}
		response.sendRedirect("list");
	}

}
