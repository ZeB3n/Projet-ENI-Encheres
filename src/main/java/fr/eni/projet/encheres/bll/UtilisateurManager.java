package fr.eni.projet.encheres.bll;

import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.DAOFactory;

public class UtilisateurManager {
	
//	private UtilisateurDAO utilisateurDAO;
	
	// Singleton
	// utilisateurManager = instance
	private static UtilisateurManager utilisateurManager;
	
	private UtilisateurManager() {
	}
	
	public static UtilisateurManager getUtilisateurManager() {
		if(utilisateurManager == null) {
			utilisateurManager = new UtilisateurManager();
		}
		return utilisateurManager;
	}
	
	public Utilisateur connexion(String pseudo, String mot_de_passe) throws Exception {
		validationPseudo(pseudo);
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectByPseudo(pseudo);
		if (!mot_de_passe.equals(utilisateur.getMotDePasse())){
			throw new Exception("Le mot de passe est erroné.");
		}
		return utilisateur;
	}
	
    private void validationPseudo(String pseudo) throws Exception {
    	Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectByPseudo(pseudo);
    	if (utilisateur == null) {
    		throw new Exception("Le pseudo est inconnu.");
    	}
	}
	
	
//	public Utilisateur ajouterUtilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal,
//								   		  String ville, String mot_de_passe, String confirmation) throws BusinessException {
//		BusinessException businessException = new BusinessException();
//		
//		this.validationPseudo(pseudo, businessException);
//		this.validationNom(nom, businessException);
//		this.validationPrenom(prenom, businessException);
//		this.validationEmail(email, businessException);
//		this.validationTelephone(telephone, businessException);
//		this.validationRue(rue, businessException);
//		this.validationCodePostal(code_postal, businessException);
//		this.validationVille(ville, businessException);
//		this.validationMotDePasse(mot_de_passe, businessException);
//		this.validationConfirmation(mot_de_passe, confirmation, businessException);
//		
//		Utilisateur utilisateur = null;
//		
//		if(!businessException.hasErreurs())
//		{
//			utilisateur = new Utilisateur();
//			utilisateur.setPseudo(pseudo);
//			utilisateur.setNom(nom);
//			utilisateur.setPrenom(prenom);
//			utilisateur.setEmail(email);
//			utilisateur.setTelephone(telephone);
//			utilisateur.setRue(rue);
//			utilisateur.setCodePostal(code_postal);
//			utilisateur.setVille(ville);
//			utilisateur.setMotDePasse(mot_de_passe);
//			
//			this.utilisateurDAO.insertUtilisateur(utilisateur);
//		}
//		else
//		{
//			throw businessException;
//		}
//		return utilisateur;	
//	
//	}
//	
// ------------------------------------------------------------------------------------	
//			 Map passée en List via BusinessException
	
//    private String resultat;
//    private Map<String, String> erreurs      = new HashMap<String, String>();
//
//    public String getResultat() {
//        return resultat;
//    }
//
//    public Map<String, String> getErreurs() {
//        return erreurs;
//    }
// ------------------------------------------------------------------------------------
	
//    public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
//		String pseudo = getValeurChamp(request, "pseudo");
//		String nom = getValeurChamp(request, "nom");
//		String prenom = getValeurChamp(request, "prenom");
//        String email = getValeurChamp( request, "email" );
//		String telephone = getValeurChamp(request, "telephone");
//		String rue = getValeurChamp(request, "rue");
//		String code_postal = getValeurChamp(request, "code_postal");
//		String ville = getValeurChamp(request, "ville");
//        String mot_de_passe = getValeurChamp( request, "mot_de_passe" );
//        String confirmation = getValeurChamp( request, "confirmation" );
//
//        Utilisateur utilisateur = new Utilisateur();
//
//		try {
//			validationPseudo( pseudo );
//		} catch (Exception e) {
//			setErreur("pseudo", e.getMessage());
//		}
//		utilisateur.setPseudo( pseudo );
//        
//		try {
//			validationNom( nom );
//		} catch (Exception e) {
//			setErreur("nom", e.getMessage());
//		}
//		utilisateur.setNom( nom );
//		
//		try {
//			validationPrenom( prenom );
//		} catch (Exception e) {
//			setErreur("prenom", e.getMessage());
//		}
//		utilisateur.setPrenom( prenom );
//		
//        try {
//            validationEmail( email );
//        } catch ( Exception e ) {
//            setErreur( "email", e.getMessage() );
//        }
//        utilisateur.setEmail( email );
//
//		try {
//			validationTelephone( telephone );
//		} catch (Exception e) {
//			setErreur("telephone", e.getMessage());
//		}
//		utilisateur.setTelephone( telephone );
//        
//		try {
//			validationRue( rue );
//		} catch (Exception e) {
//			setErreur("rue", e.getMessage());
//		}
//		utilisateur.setRue( rue );
//		
//		try {
//			validationCodePostal( code_postal );
//		} catch (Exception e) {
//			setErreur("code_postal", e.getMessage());
//		}
//		utilisateur.setCodePostal( code_postal );
//		
//		try {
//			validationVille(ville);
//		} catch (Exception e) {
//			setErreur("ville", e.getMessage());
//		}
//		utilisateur.setVille( ville );
//		
//        try {
//            validationConfirmation( mot_de_passe, confirmation );
//        } catch ( Exception e ) {
//            setErreur( "mot_de_passe", e.getMessage() );
//            setErreur( "confirmation", null );
//        }
//        utilisateur.setMotDePasse( "" );
//        
//        return utilisateur;
//    }
//    
//  ---------------------------------------------------------------------------------------
	
//					METHODE DE RECUPERATION ET VALIDATION CHAMPS FORMULAIRE		
			
//    public Utilisateur connecterUtilisateur( HttpServletRequest request ) {
//        /* Récupération des champs du formulaire */
//        String email = getValeurChamp( request, "email" );
//        String mot_de_passe = getValeurChamp( request, "mot_de_passe" );
//        
//        Utilisateur utilisateur = new Utilisateur();
//        
//        /* Validation du champ email. */
//        try {
//            validationEmail( email );
//        } catch ( Exception e ) {
//            setErreur( "email", e.getMessage() );
//        }
//        utilisateur.setEmail( email );
//        
//        /* Validation du champ mot de passe. */
//        try {
//            validationMotDePasse( mot_de_passe );
//        } catch ( Exception e ) {
//            setErreur( "mot_de_passe", e.getMessage() );
//        }
//        utilisateur.setMotDePasse( mot_de_passe );
//        
//        /* Initialisation du résultat global de la validation. */
//        if ( erreurs.isEmpty() ) {
//            resultat = "Succès de la connexion.";
//        } else {
//            resultat = "Échec de la connexion.";
//        }
//        
//        return utilisateur;
//    }
	
//  ---------------------------------------------------------------------------------------
	
//				ANCIENNE METHODE DE VALIDATION
	
//	private static void validationPseudo(String pseudo) throws Exception {
//		if (pseudo != null ) {
//			if (pseudo.length() > 30){
//				throw new Exception ( "Le pseudo doit contenir moins de 30 caractères." );
//			}
//		} else {
//			throw new Exception( "Merci de saisir un pseudo." );
//		}
//	}
//    
//	private static void validationNom(String nom) throws Exception {
//		if (nom != null ) {
//			if (nom.length() > 30){
//				throw new Exception ( "Le nom doit contenir moins de 30 caractères." );
//			}
//		} else {
//			throw new Exception( "Merci de saisir un nom." );
//		}
//	}
//	
//	private static void validationPrenom(String prenom) throws Exception {
//		if (prenom != null ) {
//			if (prenom.length() > 30){
//				throw new Exception ( "Le prénom doit contenir moins de 30 caractères." );
//			}
//		} else {
//			throw new Exception( "Merci de saisir un prénom." );
//		}
//	}
//	
//    private void validationEmail( String email ) throws Exception {
//        if ( email != null ) {
//            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
//                throw new Exception( "Merci de saisir une adresse mail valide." );
//            } else if ( email.length() > 50 ) {
//            throw new Exception( "L'email doit contenir moins de 50 caractères." );
//            }
//        } else {
//            throw new Exception( "Merci de saisir une adresse mail." );
//        }
//    }
//    
//	private static void validationTelephone(String telephone) throws Exception {
//        if ( telephone != null ) {
//            if ( telephone.length() >= 1 && telephone.length() < 10 ) {
//                throw new Exception( "Le téléphone doit contenir au moins 10 caractères." );
//            }
//        } else {
//            return;
//        }
//    }
//	
//	private static void validationRue(String rue) throws Exception {
//		if (rue != null ) {
//			if (rue.length() > 30){
//				throw new Exception ( "La rue doit contenir moins de 30 caractères." );
//			}
//		} else {
//			throw new Exception( "Merci de saisir une rue." );
//		}
//	}
//    
//	private static void validationCodePostal(String code_postal) throws Exception {
//		if (code_postal != null ) {
//			if (code_postal.length() > 10 ){
//				throw new Exception ( "Le code postal doit contenir moins de 10 caractères." );
//			}
//		} else {
//			throw new Exception( "Merci de saisir un code postal." );
//		}
//	}
//	
//	private static void validationVille(String ville) throws Exception {
//		if (ville != null ) {
//			if (ville.length() > 30 ){
//				throw new Exception ( "La ville doit contenir moins de 30 caractères." );
//			}
//		} else {
//			throw new Exception( "Merci de saisir une ville." );
//		}
//	}
//	
//    private void validationConfirmation( String motDePasse, String confirmation ) throws Exception {
//        if ( motDePasse != null && confirmation != null ) {
//            if ( !motDePasse.equals( confirmation ) ) {
//                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
//            } else if ( motDePasse.length() > 30 ) {
//                throw new Exception( "Les mots de passe doivent contenir moins de 30 caractères." );
//            }
//        } else {
//            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
//        }
//    }
//    
//    private void validationMotDePasse( String mot_de_passe ) throws Exception {
//        if ( mot_de_passe != null ) {
//            if ( mot_de_passe.length() < 3 ) {
//                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
//            }
//        } else {
//            throw new Exception( "Merci de saisir votre mot de passe." );
//        }
//    }
//    ----------------------------------------------------------------------------------------------------
//    /*
//     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
//     */
//    private void setErreur( String champ, String message ) {
//        erreurs.put( champ, message );
//    }
//    
//    /*
//     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
//     * sinon.
//     */
//    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
//        String valeur = request.getParameter( nomChamp );
//        if ( valeur == null || valeur.trim().length() == 0 ) {
//            return null;
//        } else {
//            return valeur.trim();
//        }
//    }
//    
//    private void validationPseudo(String pseudo, BusinessException businessException) {
//		if (pseudo != null) {
//			if (pseudo.trim().length()>30){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_TAILLE); 
//				// Message à afficher = "Le pseudo doit contenir moins de 30 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_NULL); 
//			// Message à afficher = "Merci de saisir un pseudo."
//		}
//	}
//    
//    private void validationNom(String nom, BusinessException businessException) {
//		if (nom != null) {
//			if (nom.trim().length()>30){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_NOM_TAILLE); 
//				// Message à afficher = "Le nom doit contenir moins de 30 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_NOM_NULL); 
//			// Message à afficher = "Merci de saisir un nom."
//		}
//	}
//    
//    private void validationPrenom(String prenom, BusinessException businessException) {
//		if (prenom != null) {
//			if (prenom.trim().length()>30){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_PRENOM_TAILLE); 
//				// Message à afficher = "Le prenom doit contenir moins de 30 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_PRENOM_NULL); 
//			// Message à afficher = "Merci de saisir un prenom."
//		}
//	}
//    
//    private void validationEmail(String email, BusinessException businessException) {
//		if (email != null) {
//			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_EMAIL_FORMAT);
//				// TODO : Message à afficher = "Merci de saisir une adresse mail valide."
//			} else if (email.trim().length()>50){
//					businessException.ajouterErreur(CodesResultatBLL.REGLE_EMAIL_TAILLE); 
//					// Message à afficher = "Le email doit contenir moins de 50 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_EMAIL_NULL); 
//			// Message à afficher = "Merci de saisir un email."
//		}
//	}
//    
//    private void validationTelephone(String telephone, BusinessException businessException) {
//		if (telephone != null) {
//			if (telephone.trim().length()>=1 && telephone.length()<10){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_TELEPHONE_TAILLE); 
//				// Message à afficher = "Le téléphone doit contenir moins de 10 caractères."
//			}
//		} else {
//			return;
//		}
//	}
//    
//    private void validationRue(String rue, BusinessException businessException) {
//		if (rue != null) {
//			if (rue.trim().length()>30){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_RUE_TAILLE); 
//				// Message à afficher = "Le rue doit contenir moins de 30 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_RUE_NULL); 
//			// Message à afficher = "Merci de saisir une rue."
//		}
//	}
//    
//    private void validationCodePostal(String code_postal, BusinessException businessException) {
//		if (code_postal != null) {
//			if (code_postal.trim().length()>10){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_CODEPOSTAL_TAILLE); 
//				// Message à afficher = "Le code postal doit contenir moins de 10 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_CODEPOSTAL_NULL); 
//			// Message à afficher = "Merci de saisir un code postal."
//		}
//	}
//    
//    private void validationVille(String ville, BusinessException businessException) {
//		if (ville != null) {
//			if (ville.trim().length()>10){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_VILLE_TAILLE); 
//				// Message à afficher = "Le ville doit contenir moins de 30 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_VILLE_NULL); 
//			// Message à afficher = "Merci de saisir une ville."
//		}
//	}
//    
//    private void validationMotDePasse(String mot_de_passe, BusinessException businessException) {
//		if (mot_de_passe != null) {
//			if (mot_de_passe.trim().length()<3){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_MDP_TAILLE); 
//				// Message à afficher = "Le mot de passe doit contenir au moins 3 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_MDP_NULL); 
//			// Message à afficher = "Merci de saisir un mot de passe."
//		}
//	}
//    
//    private void validationConfirmation(String mot_de_passe, String confirmation, BusinessException businessException) {
//		if (mot_de_passe != null && confirmation != null) {
//			if (!mot_de_passe.equals(confirmation)){
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_CONFIRMATIONMDP_DIFFERENTS); 
//				//  Message à afficher = "Les mots de passe entrés sont différents, merci de les saisir à nouveau."
//			} else if ( mot_de_passe.length() > 30 ) {
//				businessException.ajouterErreur(CodesResultatBLL.REGLE_CONFIRMATIONMDP_TAILLE);
//	          // Message à afficher = "Les mots de passe doivent contenir moins de 30 caractères."
//			}
//		} else {
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_CONFIRMATIONMDP_NULL); 
//			// Message à afficher = "Merci de saisir et confirmer votre mot de passe."
//		}
//	}
}