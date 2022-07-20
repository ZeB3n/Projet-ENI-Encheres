package fr.eni.projet.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbc implements UtilisateurDAO {
	
	private static final String SELECT_CONNEXION_UTILISATEUR="SELECT INTO utilisateur(pseudo, email, mot_de_passe) VALUES(?,?,?);";

	@Override
	public List<Utilisateur> select() {

		return null;
		
	}
}

