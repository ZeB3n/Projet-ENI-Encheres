package fr.eni.projet.encheres.bll;

import java.util.HashMap;
import java.util.Map;

import fr.eni.projet.encheres.bo.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;

public class InscriptionForm {
	
	private static final 	String CHAMP_PSEUDO = "pseudo";
	private static final 	String CHAMP_NOM = "nom";
	private static final 	String CHAMP_PRENOM = "prenom";
	private static final 	String CHAMP_EMAIL  = "email";
	private static final 	String CHAMP_TEL = "telephone";
	private static final 	String CHAMP_RUE = "rue";
	private static final 	String CHAMP_CP = "code_postal";
	private static final 	String CHAMP_VILLE = "ville";
    private static final 	String CHAMP_PASS   = "motdepasse";
    private static final 	String CHAMP_CONF   = "confirmation";
    private 				String resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
    	String pseudo = getValeurChamp( request, CHAMP_PSEUDO );
    	String nom = getValeurChamp( request, CHAMP_NOM );
    	String prenom = getValeurChamp( request, CHAMP_PRENOM );
    	String email = getValeurChamp( request, CHAMP_EMAIL );
    	String telephone = getValeurChamp( request, CHAMP_TEL );
    	String rue = getValeurChamp( request, CHAMP_RUE );
    	String code_postal = getValeurChamp( request, CHAMP_CP );
    	String ville = getValeurChamp( request, CHAMP_VILLE );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );

        Utilisateur utilisateur = new Utilisateur();
        
        try {
            validationPseudo( pseudo );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        utilisateur.setPseudo( pseudo );
        
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( email );

        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );
        
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail ( email );
        
        try {
            validationTelephone( telephone );
        } catch ( Exception e ) {
            setErreur( CHAMP_TEL, e.getMessage() );
        }
        utilisateur.setTelephone( telephone );
        
        try {
            validationRue( rue );
        } catch ( Exception e ) {
            setErreur( CHAMP_RUE, e.getMessage() );
        }
        utilisateur.setRue( rue );
        
        try {
            validationCode_postal( code_postal );
        } catch ( Exception e ) {
            setErreur( CHAMP_CP, e.getMessage() );
        }
        utilisateur.setCode_postal( code_postal );
        
        try {
            validationVille( ville );
        } catch ( Exception e ) {
            setErreur( CHAMP_VILLE, e.getMessage() );
        }
        utilisateur.setVille( ville );

        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }
        utilisateur.setMotDePasse( motDePasse );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        return utilisateur;
    }
    
    private void validationPseudo( String pseudo ) throws Exception {
        if ( pseudo != null && pseudo.length() < 3 ) {
            throw new Exception( "Le pseudo doit contenir au moins 3 caractères." );
        }
    }
    
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() != 0 ) {
            throw new Exception( "Le nom est requis." );
        }
    }
    
    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() != 0 ) {
            throw new Exception( "Le prénom est requis." );
        }
    }
    
    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    
    private void validationTelephone( String telephone ) throws Exception {
        if ( !telephone.matches("(^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$)")) {
            throw new Exception( "Format invalide." );
        }
    }
    
    private void validationRue( String rue ) throws Exception {
        if ( rue != null && rue.length() != 0 ) {
            throw new Exception( "La rue est requise (ou voie, impasse,lieu-dit, etc...)." );
        }
    }
    
    private void validationCode_postal( String code_postal ) throws Exception {
        if ( code_postal != null && code_postal.length() != 0 ) {
            throw new Exception( "Le code postal est requis." );
        }
    }
    
    private void validationVille( String ville ) throws Exception {
        if ( ville != null && ville.length() != 0 ) {
            throw new Exception( "La ville est requise." );
        }
    }

    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( !motDePasse.matches("(^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$)")) {
				throw new Exception("Le mot de passe doit contenir au moins 8 caractères, dont 1 caractère spécial, un chiffre, et une majuscule.");
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}