package fr.eni.projet.encheres.bll;

import java.util.HashMap;
import java.util.Map;

import fr.eni.projet.encheres.bo.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;

public class UtilisateurManager {
	private static String              resultat;
	private static Map<String, String> erreurs = new HashMap<String, String>();

	
	/* public static void insererUtilisateur(Utilisateur utilisateur) {
		// TODO : Appel de la méthode validationUtilisateur puis appel de la méthode insererUtilisateur de la DAL.
	} */
		
	public String getResultat() {
	        return resultat;
	}
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Utilisateur insererUtilisateur ( HttpServletRequest request) {
		/* Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo(request.getParameter("pseudo"));
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setTelephone(request.getParameter("telephone"));
		utilisateur.setRue(request.getParameter("rue"));
		utilisateur.setCode_postal(request.getParameter("code_postal"));
		utilisateur.setVille(request.getParameter("ville"));
		utilisateur.setMotDePasse(request.getParameter("mot_de_passe")); */
		
		String pseudo = getValeurChamp(request, "pseudo");
		String nom = getValeurChamp(request, "nom");
		String prenom = getValeurChamp(request, "prenom");
		String email = getValeurChamp(request, "email");
		String telephone = getValeurChamp(request, "telephone");
		String rue = getValeurChamp(request, "rue");
		String code_postal = getValeurChamp(request, "code_postal");
		String ville = getValeurChamp(request, "ville");
		String mot_de_passe = getValeurChamp(request, "mot_de_passe");
		String confirmation = getValeurChamp(request, "confirmation");
		
		Utilisateur utilisateur = new Utilisateur();
		
		/* Validation du champ Pseudo */
		try {
			validationPseudo(pseudo);
		} catch (Exception e) {
			setErreur("pseudo", e.getMessage());
		}
		utilisateur.setPseudo("pseudo");
		
			/* Validation du champ Nom */
		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur("nom", e.getMessage());
		}
		utilisateur.setNom("nom");
		
			/* Validation du champ Prénom */
		try {
			validationPrenom(prenom);
		} catch (Exception e) {
			setErreur("prenom", e.getMessage());
		}
		utilisateur.setPrenom("prenom");
		
			/* Validation du champ Email */
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur("email", e.getMessage());
		}
		utilisateur.setEmail("email");
		
			/* Validation du champ Téléphone */
		try {
			validationTelephone(telephone);
		} catch (Exception e) {
			setErreur("telephone", e.getMessage());
		}
		utilisateur.setTelephone("telephone");
			
			/* Validation du champ Rue */
		try {
			validationRue(rue);
		} catch (Exception e) {
			setErreur("rue", e.getMessage());
		}
		utilisateur.setRue("rue");
		
			/* Validation du champ Code Postal */
		try {
			validationCode_Postal(code_postal);
		} catch (Exception e) {
			setErreur("code_postal", e.getMessage());
		}
		utilisateur.setCode_postal("code_postal");
		
			/* Validation du champ Ville */
		try {
			validationVille(ville);
		} catch (Exception e) {
			setErreur("ville", e.getMessage());
		}
		utilisateur.setVille("ville");
		
			/* Validation des champs Mot de passe et Confirmation */
		try {
			validationMot_De_Passe(mot_de_passe, confirmation);
		} catch (Exception e) {
			setErreur("mot_de_passe", e.getMessage());
			setErreur("confirmation", null);
		}
		utilisateur.setMotDePasse("mot_de_passe");
		
		/* Résulat global de validation */
		if (erreurs.isEmpty()) {
			resultat = "Inscription réussie.";
		} else {
			resultat = "Vous êtes nul, pas foutu de remplir 10 cases! Grosse merde!!";
		}
		
		return utilisateur;
	}
	/* Gestion des erreurs de validation */
	
	/* Méthode de Validation des champs Mot de passe et Confirmation */
	private static void validationMot_De_Passe(String mot_de_passe, String confirmation) throws Exception {
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
	private static void validationVille(String ville) throws Exception {
		if (ville != null && ville.trim().length() != 0) {
			throw new Exception("Le champ ville doit être rempli");
		}
	}

	/* Méthode de Validation du champ Code Postal (Certains pays ont une lettre dans leur code postal) */
	private static void validationCode_Postal(String code_postal) throws Exception {
		if (code_postal != null && code_postal.trim().length() != 0) {
			throw new Exception("Le champ code postal doit être rempli");
		}
	}

	/* Méthode de Validation du champ Rue */
	private static void validationRue(String rue) throws Exception {
		if (rue != null && rue.trim().length() != 0) {
			throw new Exception("Le champ rue doit être rempli");
		}
	}

	/* Méthode de Validation du champ Téléphone */
	private static void validationTelephone(String telephone) throws Exception {
		if (telephone != null && telephone.trim().length() != 0) {
			if ( !telephone.matches("(^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$)")) {
				throw new Exception("Le champ téléphone doit être valide");
			}
		} else {
			throw new Exception("Le champ téléphone doit être rempli");
		}
	}

	/* Méthode de Validation du champ Email */
	private static void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if ( !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Saisir une adresse email valide (pas de @ présent)");
			}
		} else {
			throw new Exception("Le champ email doit être rempli");
		}
		
	}

	/* Méthode de Validation du champ Prénom */
	private static void validationPrenom(String prenom) throws Exception {
		if (prenom != null && prenom.trim().length() != 0) {
			throw new Exception("Le champ prénom doit être rempli");
		}
	}

	/* Méthode de Validation du champ Nom */
	private static void validationNom(String nom) throws Exception {
		if (nom != null && nom.trim().length() != 0) {
			throw new Exception("Le champ nom doit être rempli");
		}
	}

	/* Méthode de Validation du champ Pseudo */
	private static void validationPseudo(String pseudo) throws Exception {
		if (pseudo != null && pseudo.trim().length() < 3) {
			throw new Exception("Le champ pseudo doit contenir au moins 3 caractères");
		}
	}
	
	/*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private static void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}

