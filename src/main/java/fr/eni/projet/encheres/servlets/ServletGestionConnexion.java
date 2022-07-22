package fr.eni.projet.encheres.servlets;

import java.io.IOException;

import fr.eni.projet.encheres.bll.ConnexionForm;
import fr.eni.projet.encheres.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletGestionConnexion extends HttpServlet {
	private static final long serialVersionUID  = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ACCUEIL 			= "/WEB-INF/jsp/accueil.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( ACCUEIL ).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );

        this.getServletContext().getRequestDispatcher( ACCUEIL ).forward( request, response );
    }


}

