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
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		Utilisateur utilisateur = new Utilisateur();
		
		Map<String, String> erreurs = new HashMap<String, String>();
		/* Traitement des données du formulaire */
		
		/* Récupération des champs du formulaire */
		utilisateur.setPseudo(request.getParameter("pseudo"));
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setTelephone(request.getParameter("telephone"));
		utilisateur.setRue(request.getParameter("rue"));
		utilisateur.setCode_postal(request.getParameter("code_postal"));
		utilisateur.setVille(request.getParameter("ville"));
		utilisateur.setMotDePasse(request.getParameter("mot_de_passe"));
		
		// Appel de la BLL pour contrôle règle de gestion
		
		UtilisateurManager.insererUtilisateur(utilisateur);
		
		/* Transmission à la JSP */
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}
	

	/* Gestion des erreurs de validation */
	
	/* Méthode de Validation des champs Mot de passe et Confirmation */
	private void validationMot_De_Passe(String mot_de_passe, String confirmation) throws Exception {
		if (mot_de_passe != null && mot_de_passe.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
			if(!mot_de_passe.equals(confirmation)) {
				throw new Exception("Mots de passe renseignés différents, saisir le même mot de passe.");
			} else if ( !mot_de_passe.matches("(^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$)")) {
				throw new Exception("Le mot de passe doit contenir au moins 8 caractères, dont 1 caractère spécial, un chiffre, et une majuscule.");
			}
		} else {
			throw new Exception("Saisir, puis confirmer le mot de passe.");
		}
		
	}

	/* Méthode de Validation du champ Ville */
	private void validationVille(String ville) throws Exception {
		if (ville != null && ville.trim().length() != 0) {
			throw new Exception("Le champ ville doit être rempli");
		}
	}

	/* Méthode de Validation du champ Code Postal (Certains pays ont une lettre dans leur code postal) */
	private void validationCode_Postal(String code_postal) throws Exception {
		if (code_postal != null && code_postal.trim().length() != 0) {
			throw new Exception("Le champ code postal doit être rempli");
		}
	}

	/* Méthode de Validation du champ Rue */
	private void validationRue(String rue) throws Exception {
		if (rue != null && rue.trim().length() != 0) {
			throw new Exception("Le champ rue doit être rempli");
		}
	}

	/* Méthode de Validation du champ Téléphone */
	private void validationTelephone(String telephone) throws Exception {
		if (telephone != null && telephone.trim().length() != 0) {
			if ( !telephone.matches("(^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$)")) {
				throw new Exception("Le champ téléphone doit être valide");
			}
		} else {
			throw new Exception("Le champ téléphone doit être rempli");
		}
	}

	/* Méthode de Validation du champ Email */
	private void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if ( !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Saisir une adresse email valide (pas de @ présent)");
			}
		} else {
			throw new Exception("Le champ email doit être rempli");
		}
		
	}

	/* Méthode de Validation du champ Prénom */
	private void validationPrenom(String prenom) throws Exception {
		if (prenom != null && prenom.trim().length() != 0) {
			throw new Exception("Le champ prénom doit être rempli");
		}
	}

	/* Méthode de Validation du champ Nom */
	private void validationNom(String nom) throws Exception {
		if (nom != null && nom.trim().length() != 0) {
			throw new Exception("Le champ nom doit être rempli");
		}
	}

	/* Méthode de Validation du champ Pseudo */
	private void validationPseudo(String pseudo) throws Exception {
		if (pseudo != null && pseudo.trim().length() != 0) {
			throw new Exception("Le champ pseudo doit être rempli");
		}
	}
}

