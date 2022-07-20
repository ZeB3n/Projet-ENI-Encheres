package fr.eni.projet.encheres.bo;

import java.io.Serializable;

/**
 * javabean permettant d'instancier un objet de type Utilisateur
 * @author Goulven
 *
 */
public class Utilisateur implements Serializable {
	// Attributs
	private static final long serialVersionUID = 1L;
	private int no_utilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String code_postal;
	private String ville;
	private String mot_de_passe;
	private int credit;
	private boolean administrateur;

// Constructeurs
public Utilisateur() {
	
}

/**
 * Méthode permettant d'instancier un objet de type utilisateur et d'en hydrater les attributs
 * @param nom nom de l'utilisateur
 * @param prenom prenom de l'utilisateur
 * @param email email de l'utilisateur
 * @param rue
 * @param code_postal
 * @param ville
 * @param mot_de_passe
 * @param credit
 * @param administrateur
 */
public Utilisateur(String nom, String prenom, String email, String rue, String code_postal, String ville,
		String mot_de_passe, int credit, boolean administrateur) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.rue = rue;
	this.code_postal = code_postal;
	this.ville = ville;
	this.mot_de_passe = mot_de_passe;
	this.credit = credit;
	this.administrateur = administrateur;
}

@Override
public String toString() {
	return "Utilisateur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
			+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_postal="
			+ code_postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
			+ ", administrateur=" + administrateur + "]";
}

// Getters-Setters
public int getNo_utilisateur() {
	return no_utilisateur;
}


public void setNo_utilisateur(int no_utilisateur) {
	this.no_utilisateur = no_utilisateur;
}


public String getPseudo() {
	return pseudo;
}


public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public String getPrenom() {
	return prenom;
}


public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getTelephone() {
	return telephone;
}


public void setTelephone(String telephone) {
	this.telephone = telephone;
}


public String getRue() {
	return rue;
}


public void setRue(String rue) {
	this.rue = rue;
}


public String getCode_postal() {
	return code_postal;
}


public void setCode_postal(String code_postal) {
	this.code_postal = code_postal;
}


public String getVille() {
	return ville;
}


public void setVille(String ville) {
	this.ville = ville;
}


public String getMot_de_passe() {
	return mot_de_passe;
}


public void setMotDePasse(String mot_de_passe) {
	this.mot_de_passe = mot_de_passe;
}


public int getCredit() {
	return credit;
}


public void setCredit(int credit) {
	this.credit = credit;
}


public boolean isAdministrateur() {
	return administrateur;
}


public void setAdministrateur(boolean administrateur) {
	this.administrateur = administrateur;
}

}

