package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LivreDAOMySQL;
import model.Utilisateur;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session; 
	private LivreDAOMySQL biblio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		biblio = new LivreDAOMySQL();
		request.setAttribute("biblio", biblio.getLivres());
		
		this.getServletContext().getRequestDispatcher("/view/home.jsp").forward(request, response);
		session.removeAttribute("info");
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// récuperation du nom du formaulraire
		String nomFormulaire = request.getParameter("hidden").toString();
		
		
		// action pour les différents formulaires
		if(nomFormulaire.equals("deconnexion")) {
			
			session = request.getSession();
			session.invalidate();
			
			response.sendRedirect( request.getContextPath() + "/login");
			
			
			
		} else if(nomFormulaire.equals("ajouter")){
			
			LivreDAOMySQL livreDAOMySQL = new LivreDAOMySQL();
			session = request.getSession();
			Utilisateur uti = (Utilisateur)session.getAttribute("utilisateur");
			
			String titre = request.getParameter("inputTitre");
			int tome = Integer.parseInt(request.getParameter("inputTome"));
			int genre = Integer.parseInt(request.getParameter("inputGenre"));
			int idUtilisateur = uti.getUtilisateurId();
						
			if(livreDAOMySQL.createLivre(titre, tome, genre, idUtilisateur)) {
				session.setAttribute("info", "Livre ajouté !");
			} else {
				session.setAttribute("info", "Problème lors de l'ajout du livre !!");
			}
						
			response.sendRedirect( request.getContextPath() + "/home");
			
			
			
		} else if(nomFormulaire.equals("modifier")) {
			
			LivreDAOMySQL livreDAOMySQL = new LivreDAOMySQL();
			
			int tome = Integer.parseInt(request.getParameter("inputTome"));
			int idLivre = Integer.parseInt(request.getParameter("inputId"));
			
			livreDAOMySQL.updateLivre(idLivre, tome);
			
			response.sendRedirect(request.getContextPath() + "/home");
			
			
			
		} else if(nomFormulaire.equals("effacer")) {
			
			LivreDAOMySQL livreDAOMySQL = new LivreDAOMySQL();
			
			int idLivre = Integer.parseInt(request.getParameter("inputId"));
			
			livreDAOMySQL.deleteLivre(idLivre);
			
			response.sendRedirect(request.getContextPath() + "/home");
			
			
		}
		
	}

}
