package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDAO;
import dao.UtilisateurDAOMySQL;
import sun.invoke.empty.Empty;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/view/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
					
		UtilisateurDAOMySQL utilisateurDAOMySQL = new UtilisateurDAOMySQL();
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("MDP");
		
		if(utilisateurDAOMySQL.checkUtilisateur(pseudo, mdp)) {
			session = request.getSession();
			session.setAttribute("utilisateur", utilisateurDAOMySQL.connectUtilisateur(pseudo, mdp));
			
			response.sendRedirect( request.getContextPath() + "/home");
			
		} else {
			request.setAttribute("info", "Pseudo ou Mot de passe incorrect !");
			this.getServletContext().getRequestDispatcher("/view/login.jsp").forward(request, response);
		}
		
	}

}
