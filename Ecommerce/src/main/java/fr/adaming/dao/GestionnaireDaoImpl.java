package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fr.adaming.model.Categorie;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.Produit;

@Repository
public class GestionnaireDaoImpl implements IEditerDao {
	
	
	@Autowired
	private SessionFactory sf;

	


	@Override
	public void ajouterProduit(Produit p) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerCategorie(Categorie c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Gestionnaire> isExistGestionnaireDao(String nom, String prenom, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	/** getters et setters */
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
