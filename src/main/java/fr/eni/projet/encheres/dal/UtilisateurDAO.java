package fr.eni.projet.encheres.dal;

import fr.eni.javaee.module4.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;

public class UtilisateurDAO {

	public interface AvisDAO {
		/**
		 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
		 * @param utilisateur
		 * @throws BusinessException
		 */
		public void insert(Utilisateur utilisateur) throws BusinessException;
	}
}
