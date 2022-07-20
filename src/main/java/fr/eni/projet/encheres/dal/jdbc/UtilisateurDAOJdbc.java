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
import fr.eni.projet.encheres.dal.ConnectionProvider;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbc implements UtilisateurDAO {
	
	private static final String SELECT_CONNEXION_UTILISATEUR="SELECT * FROM utilisateur WHERE login = ? AND mot_de_passe = ?";
	
	@Override
	public Utilisateur rechercher(String login, String mot_de_passe) throws SQLException {
		Utilisateur utilisateur = null;
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		cnx = ConnectionProvider.getConnection();
		try {
			
			pstmt = cnx.prepareStatement(SELECT_CONNEXION_UTILISATEUR);
			pstmt.setString(1, login);
			pstmt.setString(2, mot_de_passe);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setPseudo(rs.getString("login"));
				if(rs.wasNull())
				utilisateur.setMotDePasse("<<Non renseigné>>");
				else
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.seDeconnecter(pstmt, cnx);
		}
		return utilisateur;
	}
}