package fr.eni.projet.encheres.servlets;

import java.io.IOException;

import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletInscription extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID  = 1L;
	public static final String ATT_USER		    = "utilisateur";
    public static final String ATT_FORM		    = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String INSCRIPTION	    = "/WEB-INF/jsp/inscription.jsp";
    public static final String ACCUEIL          = "/WEB-INF/jsp/accueil.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( INSCRIPTION ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Préparation de l'objet formulaire */
    	UtilisateurManager formUtilisateur = new UtilisateurManager();

        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Utilisateur utilisateur = formUtilisateur.inscrireUtilisateur( request );
        
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( formUtilisateur.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
            this.getServletContext().getRequestDispatcher( ACCUEIL ).forward( request, response );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }
        
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, formUtilisateur );
        request.setAttribute( ATT_USER, utilisateur );

        this.getServletContext().getRequestDispatcher( INSCRIPTION ).forward( request, response );
    }
}