package fr.eni.projet.encheres.dal;

/**
 * 
 * @author Groupe Benjamin-Sylvie-Goulven
 *
 * Cette classe permet de recenser les erreurs liées aux erreurs à la DAL.
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
}