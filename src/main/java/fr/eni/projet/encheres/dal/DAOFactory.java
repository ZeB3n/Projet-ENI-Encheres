package fr.eni.projet.encheres.dal;

import fr.eni.projet.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Cette classe permet de faire appel à la méthode getUtilisateurDAO de la classe UtilisateurDAO pour respecter le développement en couches
 * @author Groupe Benjamin-Sylvie-Goulven
 *
 */
public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}
}