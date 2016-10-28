package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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
		Session s = sf.getCurrentSession();
		s.update(p);
		
	}

	@Override
	public void supprimerProduit(int id_produit) {
		Session s = sf.getCurrentSession();
		Produit p = (Produit) s.get(Produit.class, id_produit);
		s.delete(p);

	}

	@Override
	public void ajouterCategorie(Categorie c) {
		Session s = sf.getCurrentSession();
		s.save(c);

	}

	@Override
	public void modifierCategorie(Categorie c) {
		Session s = sf.getCurrentSession();
		s.update(c);

	}

	@Override
	public void supprimerCategorie(int id_categorie) {
		Session s = sf.getCurrentSession();
		Categorie c = (Categorie) s.get(Categorie.class, id_categorie);
		s.delete(c);


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
