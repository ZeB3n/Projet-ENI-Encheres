package fr.eni.projet.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbc implements UtilisateurDAO {
	
	private static final String SELECT_CONNEXION_UTILISATEUR="SELECT INTO utilisateur(pseudo, mot_de_passe) VALUES(?,?);";


	@Override
	public List<Utilisateur> select() {
		Utilisateur utilisateur = null;
		PreparedStatement st;
		try {
			cnx = JdbcTools.getConnection();
			st = cnx.prepareStatement(SELECT_CONNEXION_UTILISATEUR);
			st.setPseudo(1, no_utilisateur);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setPseudo(rs.getString(1));
				utilisateur.setMotDePasse(rs.getString(2));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
}