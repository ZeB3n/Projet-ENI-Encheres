package fr.eni.projet.encheres.dal;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BusinessException.
	 * @author Groupe Benjamin-Sylvie-Goulven
	 * @param utilisateur
	 * @throws BusinessException 
	 */
	public void insererUtilisateur(Utilisateur utilisateur) throws BusinessException;
	
	// Méthode permettant de rechercher un pseudo dans la BDD
	public Utilisateur selectByPseudo(String pseudo);
		
}