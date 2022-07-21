package fr.eni.projet.encheres.bll;

import fr.eni.projet.encheres.bo.Utilisateur;

public class UtilisateurManager {

	public static void insererUtilisateur(Utilisateur utilisateur) {
		// TODO : Appel de la méthode validationUtilisateur puis appel de la méthode insererUtilisateur de la DAL.
		
	}

	private static void validationUtilisateur (Utilisateur utilisateur) {
		/* Validation du champ Pseudo */
		try {
			validationPseudo(pseudo);
		} catch (Exception e) {
			erreurs.put("pseudo", e.getMessage());
		}
		
			/* Validation du champ Nom */
		try {
			validationNom(nom);
		} catch (Exception e) {
			erreurs.put("nom", e.getMessage());
		}
		
			/* Validation du champ Prénom */
		try {
			validationPrenom(prenom);
		} catch (Exception e) {
			erreurs.put("prenom", e.getMessage());
		}
		
			/* Validation du champ Email */
		try {
			validationEmail(email);
		} catch (Exception e) {
			erreurs.put("email", e.getMessage());
		}
		
			/* Validation du champ Téléphone */
		try {
			validationTelephone(telephone);
		} catch (Exception e) {
			erreurs.put("telephone", e.getMessage());
		}
			
			/* Validation du champ Rue */
		try {
			validationRue(rue);
		} catch (Exception e) {
			erreurs.put("rue", e.getMessage());
		}
		
			/* Validation du champ Code Postal */
		try {
			validationCode_Postal(code_postal);
		} catch (Exception e) {
			erreurs.put("code_postal", e.getMessage());
		}
		
			/* Validation du champ Ville */
		try {
			validationVille(ville);
		} catch (Exception e) {
			erreurs.put("ville", e.getMessage());
		}
		
			/* Validation des champs Mot de passe et Confirmation */
		try {
			validationMot_De_Passe(mot_de_passe, confirmation);
		} catch (Exception e) {
			erreurs.put("mot_de_passe", e.getMessage());
		}
		/* Résulat global de validation */
		if (erreurs.isEmpty()) {
			resultat = "Inscription réussie.";
		} else {
			resultat = "Vous êtes nul, pas foutu de remplir 8 cases! Grosse merde!!";
		}
		
		/* Stockage du résultat et des messages */
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("resultat", resultat);
	}
		
}
