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
	
	// Requête SQL pour vérifier si les données rentrées par l'utilisateur lors de la connexion existent dans la BDD
	private static final String SELECT_CONNEXION_UTILISATEUR="SELECT * FROM UTILISATEURS WHERE pseudo = '?' OR email = '?' AND mot_de_passe = '?'";
	// Requête SQL pour vérifier à l'inscription si un pseudo existe déjà dans la BDD
	private static final String SELECT_VERIF_PSEUDO="SELECT * FROM UTILISATEURS WHERE pseudo = '?'";
	// Requête SQL pour vérifier à l'inscription si un email existe déjà dans la BDD
	private static final String SELECT_VERIF_EMAIL="SELECT * FROM UTILISATEURS WHERE email = '?'";
	
	@Override
	public Utilisateur rechercher(String pseudo, String email, String mot_de_passe) throws SQLException {
		Utilisateur utilisateur = null;
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		cnx = ConnectionProvider.getConnection();
		try {
			
			pstmt = cnx.prepareStatement(SELECT_CONNEXION_UTILISATEUR);
			pstmt.setString(1, pseudo);
			pstmt.setString(2, email);
			pstmt.setString(3, mot_de_passe);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setEmail(rs.getString("email"));
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