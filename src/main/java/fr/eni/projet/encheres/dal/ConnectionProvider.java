package fr.eni.projet.encheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Cette classe permet de récupérer les informations du fichier context.xml pour se connecter à la BDD
 * @author Groupe Benjamin-Sylvie-Goulven
 *
 */
public class ConnectionProvider {
	private static DataSource dataSource;
	
	// Externalisation de la chaîne de connexion
	static
	{
		Context context;
		try {
			// Vérifier le login
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}
	
	// Obtenir la connection
	public static Connection getConnection() throws SQLException
	{
		return ConnectionProvider.dataSource.getConnection();     
	}
}



