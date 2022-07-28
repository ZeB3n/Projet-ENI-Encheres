package fr.eni.projet.encheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Utilisateur;

public class ServletConnexion extends HttpServlet {
	
	private static final long serialVersionUID  = 1L;
    public static final String CONNEXION        = "/WEB-INF/jsp/connexion.jsp";
    public static final String ACCUEIL          = "/ServletAccueil";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	RequestDispatcher rd;
    	if(session.getAttribute("utilisateur") == null) {
    		rd = request.getRequestDispatcher(CONNEXION);
    	} else {
    		rd = request.getRequestDispatcher(ACCUEIL);
    	}
        rd.forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	String pseudo = request.getParameter("pseudo");
    	String mot_de_passe = request.getParameter("mot_de_passe");
    	Utilisateur utilisateur = null;
    	String erreur = null;
    	// On appelle la BLL
    	try {
			utilisateur = UtilisateurManager.getUtilisateurManager().connexion(pseudo, mot_de_passe);
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			erreur = e.getMessage();
			request.setAttribute("erreur", erreur);
			doGet(request, response);
		}
    }
}


//RepasManager repasManager = new RepasManager();
//try {
//	repasManager.ajouterRepas(date, heure, Arrays.asList(repas.split(",")));
//	//Si tout se passe bien, je vais vers la page de consultation:
//	RequestDispatcher rd = request.getRequestDispatcher("/repas");
//	rd.forward(request, response);
//} catch (BusinessException e) {
//	//Sinon je retourne à la page d'ajout pour indiquer les problèmes:
//	e.printStackTrace();
//	request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
//	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajout.jsp");
//	rd.forward(request, response);
//}