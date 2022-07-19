package fr.eni.projet.encheres.dal.jdbc;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbc implements UtilisateurDAO {
	
	private static final String SELECT="SELECT INTO utilisateur(pseudo, email, mot_de_passe) VALUES(?,?,?);";

	@Override
	public void select(Utilisateur utilisateur) throws BusinessException {
		
	}
	
}
