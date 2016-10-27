/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author inti0210
 *
 */
@Entity
@Table(name = "commandes")
public class Commande implements Serializable {

	/**
	 * Attributs
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_commande;
	private Date dateCommande;

	/**
	 * Constructeur vide
	 */
	public Commande() {
		super();
	}

	/**
	 * Constructeur avec paramètres sans id
	 * 
	 * @param dateCommande
	 */
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	/**
	 * Constructeur avec paramètres et id
	 * 
	 * @param id_commande
	 * @param dateCommande
	 */
	public Commande(int id_commande, Date dateCommande) {
		super();
		this.id_commande = id_commande;
		this.dateCommande = dateCommande;
	}

	/**
	 * Getters et Setters
	 */
	/**
	 * @return the id_commande
	 */
	public int getId_commande() {
		return id_commande;
	}

	/**
	 * @param id_commande
	 *            the id_commande to set
	 */
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	/**
	 * @return the dateCommande
	 */
	public Date getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande
	 *            the dateCommande to set
	 */
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
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
		return "Commande [id_commande=" + id_commande + ", dateCommande=" + dateCommande + "]";
	}

}
