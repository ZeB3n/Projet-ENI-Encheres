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
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;

// Constructeurs
public Utilisateur() {
	
}

/**
 * Méthode permettant d'instancier un objet de type utilisateur et d'en hydrater les attributs
 * @param pseudo pseudo de l'utilisateur
 * @param nom nom de l'utilisateur
 * @param prenom prenom de l'utilisateur
 * @param email email de l'utilisateur
 * @param rue rue de l'utilisateur
 * @param code_postal code_postal de l'utilisateur
 * @param ville ville de l'utilisateur
 * @param mot_de_passe mot_de_passe de l'utilisateur
 * @param credit credit de l'utilisateur
 * @param administrateur administrateur de l'utilisateur
 */
public Utilisateur(String pseudo, String nom, String prenom, String email, String rue, String codePostal, String ville,
		String motDePasse, int credit, boolean administrateur) {
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
}

public Utilisateur(String pseudo, String nom, String prenom, String email, String rue, String codePostal, String ville,
		String motDePasse) {
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
}

public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
		String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
	
		setNo_utilisateur(no_utilisateur);
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
}

@Override
public String toString() {
	return "Utilisateur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
			+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
			+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
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


public String getCodePostal() {
	return codePostal;
}


public void setCodePostal(String codePostal) {
	this.codePostal = codePostal;
}


public String getVille() {
	return ville;
}


public void setVille(String ville) {
	this.ville = ville;
}


public String getMotDePasse() {
	return motDePasse;
}


public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
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

