package fr.eni.projet.encheres.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {

	/**
	 * Echec quand le pseudo ne respecte pas les règles définies.
	 */
	public static final int REGLE_PSEUDO_TAILLE = 20000;
	
	public static final int REGLE_PSEUDO_NULL = 20001;
	
	/**
	 * Echec quand le nom ne respecte pas les règles définies.
	 */
	public static final int REGLE_NOM_TAILLE = 20002;
	
	public static final int REGLE_NOM_NULL = 20003;
	
	/**
	 * Echec quand e prénom ne respecte pas les règles définies.
	 */
	public static final int REGLE_PRENOM_TAILLE = 20004;

	public static final int REGLE_PRENOM_NULL = 20005;
	
	/**
	 * Echec quand l'email ne respecte pas les règles définies.
	 */
	public static final int REGLE_EMAIL_FORMAT = 20006;

	public static final int REGLE_EMAIL_TAILLE = 20007;

	public static final int REGLE_EMAIL_NULL = 20008;
	
	/**
	 * Echec quand le téléphone ne respecte pas les règles définies.
	 */
	public static final int REGLE_TELEPHONE_TAILLE = 20009;
	
	/**
	 * Echec quand la rue ne respecte pas les règles définies.
	 */
	public static final int REGLE_RUE_TAILLE = 20010;

	public static final int REGLE_RUE_NULL = 20011;

	/**
	 * Echec quand le code postal ne respecte pas les règles définies.
	 */
	public static final int REGLE_CODEPOSTAL_TAILLE = 20012;

	public static final int REGLE_CODEPOSTAL_NULL = 20013;

	/**
	 * Echec quand la ville ne respecte pas les règles définies.
	 */
	public static final int REGLE_VILLE_TAILLE = 20014;

	public static final int REGLE_VILLE_NULL = 20015;

	/**
	 * Echec quand le mot de passe ne respecte pas les règles définies.
	 */
	public static final int REGLE_MDP_TAILLE = 20016;

	public static final int REGLE_MDP_NULL = 20017;

	/**
	 * Echec quand la confirmation du mot de passe ne respecte pas les règles définies.
	 */
	public static final int REGLE_CONFIRMATIONMDP_DIFFERENTS = 20018;

	public static final int REGLE_CONFIRMATIONMDP_TAILLE = 20019;

	public static final int REGLE_CONFIRMATIONMDP_NULL = 20020;
	
	/**
	 * Echec à la connexion quand l'utilisateur rentre un mauvais pseudo.
	 */
	public static final int REGLE_CONNEXION_PSEUDO = 20021;

}
