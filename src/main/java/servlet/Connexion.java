package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UserDao;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_CONNEXION_UTILISATEUR = "/WEB-INF/connexion.jsp";
    

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
		if(session.getAttribute("utilisateur") == null){
			List<Utilisateur> utilisateurs = UserDao.lister();
			req.setAttribute("utilisateur", utilisateurs);
			getServletContext().getRequestDispatcher(VUE_CONNEXION_UTILISATEUR).forward(req, resp);
		} else {
			resp.sendRedirect("list");
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String motDePasse = request.getParameter("motDePasse");
		Utilisateur utilisateur = UserDao.authentification(login, motDePasse);
		HttpSession session = request.getSession();
		if(utilisateur != null) {
			session.setAttribute("utilisateur", new Utilisateur(utilisateur.getId(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getLogin(), utilisateur.getPassword()));
			List<Utilisateur> utilisateurs = UserDao.lister();
			request.setAttribute("utilisateur", utilisateurs);
			response.sendRedirect("list");
		}
		else {
			getServletContext().getRequestDispatcher(VUE_CONNEXION_UTILISATEUR).forward(request, response);
		}
			
	}	

}