package fr.eni.projet.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet SQLException.
	 * @param utilisateur
	 * @return 
	 * @throws SQLException 
	 */
//	Utilisateur rechercher(String login, String email, String mot_de_passe) throws SQLException;
	public Utilisateur selectByPseudo(String pseudo);
	public void insererUtilisateur(Utilisateur utilisateur) throws BusinessException;
		
}