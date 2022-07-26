package fr.eni.projet.encheres.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Deconnexion
 */
public class ServletDeconnexion extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ACCUEIL = "/WEB-INF/jsp/accueil.jsp";
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();
        
        /* Affichage de la page d'accueil */
        this.getServletContext().getRequestDispatcher( ACCUEIL ).forward( request, response );
    }
}
