/**
 * 
 */
package fr.adaming.model;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author inti0210
 *
 */
@Component
public class Panier {


	private Map<Integer, Integer> produitCommande;
	private double montantTotalPanier;
	
	//TODO utilis� pour recuperer une valeur du formulaire d'ajout d'un produit au panie. A faire : conotenir cette variable dans un nouveau bean
	private int quantiteProdSelectionneACommander;

	/**
	 * Constructeur vide
	 */
	public Panier() {
		super();
		produitCommande= new HashMap<Integer,Integer>();
	}

	/**
	 * Constructeur avec param�tre
	 * 
	 * @param produitCommande
	 */
	public Panier(Map<Integer, Integer> produitCommande) {
		super();
		this.produitCommande = produitCommande;
	}

	/**
	 * Getters et Setters
	 */
	/**
	 * @return the produitCommande
	 */
	public Map<Integer, Integer> getProduitCommande() {
		return produitCommande;
	}

	/**
	 * @param produitCommande
	 *            the produitCommande to set
	 */
	public void setProduitCommande(Map<Integer, Integer> produitCommande) {
		this.produitCommande = produitCommande;
	}

	/**
	 * @return the montantTotalPanier
	 */
	public double getMontantTotalPanier() {
		return montantTotalPanier;
	}

	/**
	 * @return the quantiteProdSelectionneACommander
	 */
	public int getQuantiteProdSelectionneACommander() {
		return quantiteProdSelectionneACommander;
	}

	/**
	 * @param quantiteProdSelectionneACommander the quantiteProdSelectionneACommander to set
	 */
	public void setQuantiteProdSelectionneACommander(int quantiteProdSelectionneACommander) {
		this.quantiteProdSelectionneACommander = quantiteProdSelectionneACommander;
	}

	/**
	 * @param montantTotalPanier the montantTotalPanier to set
	 */
	public void setMontantTotalPanier(double montantTotalPanier) {
		this.montantTotalPanier = montantTotalPanier;
	}

	/**
	 * Red�finition de toString
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
