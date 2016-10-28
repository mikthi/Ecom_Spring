package fr.adaming.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Repository
public class GestionnaireDaoImpl implements IEditerDao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sf;

	@Override
	public void ajouterProduit(Produit p) {
		Session s = sf.getCurrentSession();
		s.save(p);
	}

	@Override
	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerProduit(Produit p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterCategorie(Categorie c) {
		Session s = sf.getCurrentSession();
		s.save(c);

	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerCategorie(Categorie c) {
		// TODO Auto-generated method stub

	}

	/** getters et setters */

	/**
	 * @param sf
	 *            the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
