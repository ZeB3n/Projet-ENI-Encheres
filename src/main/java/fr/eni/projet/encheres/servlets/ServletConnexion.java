package fr.eni.projet.encheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Utilisateur;

/**
 * Cette servlet redirige vers la page de connexion
 * @author Groupe Benjamin-Sylvie-Goulven
 *
 */
public class ServletConnexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public static final String CONNEXION       = "/WEB-INF/jsp/connexion.jsp";
    public static final String ACCUEIL         = "/ServletAccueil";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	RequestDispatcher rd;
    	if(session.getAttribute("utilisateur") == null) {
    		// Si la session n'est pas crée, on redirige vers la jsp connexion
    		rd = request.getRequestDispatcher(CONNEXION);
    	} else {
    		// Si la session est bien crée, on redirige vers la servlet accueil
    		rd = request.getRequestDispatcher(ACCUEIL);
    	}
        rd.forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	String pseudo = request.getParameter("pseudo");
    	String mot_de_passe = request.getParameter("mot_de_passe");
    	Utilisateur utilisateur = null;
    	String erreur = null;
    	// On appelle la BLL et on test si les données envoyées par l'utilisateur sont correctes et on crée la session
    	try {
			utilisateur = UtilisateurManager.getUtilisateurManager().connexion(pseudo, mot_de_passe);
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			doGet(request, response);
		// Si une erreur est détectée, on renvoie une erreur
		} catch (Exception e) {
			e.printStackTrace();
			erreur = e.getMessage();
			request.setAttribute("erreur", erreur);
			doGet(request, response);
		}
    }
}