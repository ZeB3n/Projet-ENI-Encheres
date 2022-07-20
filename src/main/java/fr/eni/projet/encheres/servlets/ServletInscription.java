package fr.eni.projet.encheres.servlets;

import java.io.IOException;

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
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Traitement des données du formulaire */
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		String mot_de_passe = request.getParameter("mot_de_passe");
		String confirmation = request.getParameter("confirmation");
		
		try {
			validationPseudo(pseudo);
			validationNom(nom);
			validationPrenom(prenom);
			validationEmail(email);
			validationTelephone(telephone);
			validationRue(rue);
			validationCode_Postal(code_postal);
			validationVille(ville);
			validationMot_De_Passe(mot_de_passe, confirmation);
		} catch (Exception e) {
			/* Gestion des erreurs de validation */
		}
	}

	private void validationMot_De_Passe(String mot_de_passe, String confirmation) {
		// TODO Auto-generated method stub
		
	}

	private void validationVille(String ville) throws Exception {
		if (ville != null && ville.trim().length() != 0) {
			throw new Exception("Le champ ville doit être rempli");
		}
	}

	// Certains pays ont une lettre dans leur code postal
	private void validationCode_Postal(String code_postal) throws Exception {
		if (code_postal != null && code_postal.trim().length() != 0) {
			throw new Exception("Le champ code postal doit être rempli");
		}
	}

	private void validationRue(String rue) throws Exception {
		if (rue != null && rue.trim().length() != 0) {
			throw new Exception("Le champ rue doit être rempli");
		}
	}

	private void validationTelephone(String telephone) throws Exception {
		if (telephone != null && telephone.trim().length() != 0) {
			if (telephone.length() == 10) {
				throw new Exception("Le champ téléphone doit contenir 10 numéros");
			}
		} else {
			throw new Exception("Le champ téléphone doit être rempli");
		}
	}

	private void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if ( !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Saisir une adresse email valide (pas de @ présent)");
			}
		} else {
			throw new Exception("Le champ email doit être rempli");
		}
		
	}

	private void validationPrenom(String prenom) throws Exception {
		if (prenom != null && prenom.trim().length() != 0) {
			throw new Exception("Le champ prénom doit être rempli");
		}
	}

	private void validationNom(String nom) throws Exception {
		if (nom != null && nom.trim().length() != 0) {
			throw new Exception("Le champ nom doit être rempli");
		}
	}

	private void validationPseudo(String pseudo) throws Exception {
		if (pseudo != null && pseudo.trim().length() != 0) {
			throw new Exception("Le champ pseudo doit être rempli");
		}
	}
}

