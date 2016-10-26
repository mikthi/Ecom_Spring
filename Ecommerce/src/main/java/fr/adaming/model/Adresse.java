/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author inti0210
 *
 */
@Entity
@Table(name = "adresses")
public class Adresse implements Serializable{

	/**
	 * Attributs
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_adresse;
	private String voie;
	private String ville;
	private int codePostal;
	
	@OneToOne
	@JoinColumn(name="id_client", referencedColumnName="id_client")
	private Client client;

	/**
	 * Constructeur vide
	 */
	public Adresse() {
		super();
	}

	/**
	 * Constructeur avec paramètres sans id
	 * 
	 * @param voie
	 * @param ville
	 * @param codePostal
	 */
	public Adresse(String voie, String ville, int codePostal) {
		super();
		this.voie = voie;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	/**
	 * Constructeur avec paramètres et id
	 * 
	 * @param id_adresse
	 * @param voie
	 * @param ville
	 * @param codePostal
	 */
	public Adresse(int id_adresse, String voie, String ville, int codePostal) {
		super();
		this.id_adresse = id_adresse;
		this.voie = voie;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	/**
	 * Getters et Setters
	 */
	/**
	 * @return the id_adresse
	 */
	public int getId_adresse() {
		return id_adresse;
	}

	/**
	 * @param id_adresse
	 *            the id_adresse to set
	 */
	public void setId_adresse(int id_adresse) {
		this.id_adresse = id_adresse;
	}

	/**
	 * @return the voie
	 */
	public String getVoie() {
		return voie;
	}

	/**
	 * @param voie
	 *            the voie to set
	 */
	public void setVoie(String voie) {
		this.voie = voie;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 *            the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
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
		return "Adresse [id_adresse=" + id_adresse + ", voie=" + voie + ", ville=" + ville + ", codePostal="
				+ codePostal + "]";
	}

}
