package fr.eni.projet.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.ConnectionProvider;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

/**
 * Cette classe permet de faire la relation avec la BDD via des requêtes SQL
 * @author Groupe Benjamin-Sylvie-Goulven
 *
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	// Requête SQL pour vérifier si les données rentrées par l'utilisateur lors de la connexion existent dans la BDD
	private static final String SELECT_BY_PSEUDO="SELECT * FROM UTILISATEURS WHERE pseudo = ?";
	
	
	@Override
	public Utilisateur selectByPseudo(String pseudo) {
		Utilisateur utilisateur = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pStmt.setString(1, pseudo);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"),rs.getString("mot_de_passe"),rs.getInt("credit"),rs.getBoolean("administrateur"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	
	@Override
	public void insererUtilisateur(Utilisateur utilisateur) throws BusinessException {
		
	}
}

//@Override
//public Utilisateur rechercher(String pseudo, String email, String mot_de_passe) throws SQLException {
//	
//	Utilisateur utilisateur = null;
//	Connection cnx = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	
//	cnx = ConnectionProvider.getConnection();
//	try {
//		
//		pstmt = cnx.prepareStatement(SELECT_CONNEXION_UTILISATEUR);
//		pstmt.setString(1, pseudo);
//		pstmt.setString(2, email);
//		pstmt.setString(3, mot_de_passe);
//		rs = pstmt.executeQuery();
//		
//		if (rs.next()) {
//			utilisateur = new Utilisateur();
//			utilisateur.setPseudo(rs.getString("pseudo"));
//			utilisateur.setEmail(rs.getString("email"));
//			/* A effectué en cas de non-nullité dans la base de donnée */
//			/* rs.getString("mot_de_passe");
//			if(rs.wasNull())
//			utilisateur.setMotDePasse("<<Non renseigné>>");
//			else */
//			utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
//		}
//		
//	} catch (SQLException e) {
//		// TODO : à faire (lever la DALException et propager le "e")
//		e.printStackTrace();
//	} finally {
//		ConnectionProvider.seDeconnecter(pstmt, cnx);
//	}
//	return utilisateur;
//}