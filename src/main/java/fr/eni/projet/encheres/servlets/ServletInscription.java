package fr.eni.projet.encheres.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire via UtilisateurManager */
		UtilisateurManager form = new UtilisateurManager();
		
		/* Appel au traitement et à la validation de la requête ainsi qu'a la récupération de l'objet Utilisateur en résultant (BLL) */
		Utilisateur utilisateur = form.insererUtilisateur(request);
		
		/* Stockage du résultat et des messages */
		request.setAttribute("form", form);
		request.setAttribute("utilisateur", utilisateur);
		
		/*//Appel de la BLL pour contrôle règle de gestion
		
		UtilisateurManager.insererUtilisateur(utilisateur); */
		
		/* Transmission à la JSP */
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}
}

	
