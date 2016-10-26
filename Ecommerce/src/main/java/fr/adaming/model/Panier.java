/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.Map;

/**
 * @author inti0210
 *
 */
public class Panier implements Serializable {

	/**
	 * Attributs
	 */
	private static final long serialVersionUID = 1L;

	private Map<Produit, Integer> produitCommande;

	/**
	 * Constructeur vide
	 */
	public Panier() {
		super();
	}

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param produitCommande
	 */
	public Panier(Map<Produit, Integer> produitCommande) {
		super();
		this.produitCommande = produitCommande;
	}

	/**
	 * Getters et Setters
	 */
	/**
	 * @return the produitCommande
	 */
	public Map<Produit, Integer> getProduitCommande() {
		return produitCommande;
	}

	/**
	 * @param produitCommande
	 *            the produitCommande to set
	 */
	public void setProduitCommande(Map<Produit, Integer> produitCommande) {
		this.produitCommande = produitCommande;
	}

	/**
	 * Redéfinition de toString
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Panier [produitCommande=" + produitCommande + "]";
	}

}
