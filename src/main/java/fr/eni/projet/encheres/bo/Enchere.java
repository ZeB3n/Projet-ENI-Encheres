package fr.eni.projet.encheres.bo;

import java.util.Date;

/**
 * Cette classe permet d'instancier un objet de type Enchère
 * @author Groupe Benjamin-Sylvie-Goulven
 *
 */
public class Enchere {
	
	private Date date_enchere;
	private int montant_enchere;
	private Article article;
	private Utilisateur utilisateur;
	
	public Enchere() {
	}

	public Enchere(Date date_enchere, int montant_enchere, Article article, Utilisateur utilisateur) {
		super();
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.article = article;
		this.utilisateur = utilisateur;
	}

	public Date getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(Date date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@Override
	public String toString() {
		return "Enchere [date_enchere=" + date_enchere + ", montant_enchere="
				+ montant_enchere + ", article=" + article + ", utilisateur=" + utilisateur + "]";
}
}
