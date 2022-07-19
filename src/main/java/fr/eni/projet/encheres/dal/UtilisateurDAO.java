package fr.eni.projet.encheres.dal;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;

public class UtilisateurDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param utilisateur
	 * @throws BusinessException
	 */
		public void insert(Utilisateur utilisateur) throws BusinessException;
		
}
