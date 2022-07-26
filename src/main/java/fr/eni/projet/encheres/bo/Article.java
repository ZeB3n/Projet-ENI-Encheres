package fr.eni.projet.encheres.bo;

import java.sql.Date;

/**
 * Cette classe permet d'instancier un objet de type Article
 * @author Groupe Benjamin-Sylvie-Goulven
 *
 */
public class Article {
	private int no_article;
	private String nom_article;
	private String description;
	private Date date_debut_encheres;
	private Date date_fin_encheres;
	private int prix_initial; 
	private int prix_vente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	private boolean vendu;
	
public  Article() {
	}


public Article(String nom_article, String description, Date date_debut_encheres, Date date_fin_encheres,
		Utilisateur utilisateur, Categorie categorie) {
	super();
	this.nom_article = nom_article;
	this.description = description;
	this.date_debut_encheres = date_debut_encheres;
	this.date_fin_encheres = date_fin_encheres;
	this.utilisateur = utilisateur;
	this.categorie = categorie;
}


public int getNo_article() {
	return no_article;
}


public void setNo_article(int noArticle) {
	this.no_article = noArticle;
}


public String getNom_article() {
	return nom_article;
}


public void setNom_article(String nom_article) {
	this.nom_article = nom_article;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public Date getDate_debut_encheres() {
	return date_debut_encheres;
}


public void setDate_debut_encheres(Date date_debut_encheres) {
	this.date_debut_encheres = date_debut_encheres;
}


public Date getDate_fin_encheres() {
	return date_fin_encheres;
}


public void setDate_fin_encheres(Date date_fin_encheres) {
	this.date_fin_encheres = date_fin_encheres;
}


public int getPrix_initial() {
	return prix_initial;
}


public void setPrix_initial(int prix_initial) {
	this.prix_initial = prix_initial;
}


public int getPrix_vente() {
	return prix_vente;
}


public void setPrix_vente(int prix_vente) {
	this.prix_vente = prix_vente;
}


public Utilisateur getUtilisateur() {
	return utilisateur;
}


public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}


public Categorie getCategorie() {
	return categorie;
}


public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}


public boolean isVendu() {
	return vendu;
}


public void setVendu(boolean vendu) {
	this.vendu = vendu;
}


@Override
public String toString() {
	return "Article [no_article=" + no_article + ", nom_article=" + nom_article + ", description=" + description
			+ ", date_debut_encheres=" + date_debut_encheres + ", date_fin_encheres=" + date_fin_encheres
			+ ", prix_initial=" + prix_initial + ", prix_vente=" + prix_vente + ", utilisateur=" + utilisateur
			+ ", categorie=" + categorie + ", vendu=" + vendu + "]";
}
}
