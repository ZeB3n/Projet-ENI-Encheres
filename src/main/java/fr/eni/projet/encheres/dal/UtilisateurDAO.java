package fr.eni.projet.encheres.dal;

import java.util.List;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param utilisateur
	 * @throws BusinessException
	 */
	public List<Utilisateur> select() throws BusinessException;
		
}