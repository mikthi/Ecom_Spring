package fr.adaming.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEditerDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Service
@Transactional
public class GestionnaireServiceImpl extends ConsulterServiceImpl implements IEditerService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	IEditerDao gestionnaireDao;

	@Override
	public void ajouterProduit(Produit p) {
		gestionnaireDao.ajouterProduit(p);

	}

	@Override
	public void modifierProduit(Produit p) {
		gestionnaireDao.modifierProduit(p);

	}

	@Override
	public void supprimerProduit(Produit p) {
		gestionnaireDao.supprimerProduit(p);

	}

	@Override
	public void ajouterCategorie(Categorie c) {
		gestionnaireDao.ajouterCategorie(c);

	}

	@Override
	public void modifierCategorie(Categorie c) {
		gestionnaireDao.modifierCategorie(c);

	}

	@Override
	public void supprimerCategorie(Categorie c) {
		gestionnaireDao.supprimerCategorie(c);

	}

	/**
	 * Getters et Setters
	 */
	/**
	 * @param gestionnaireDao
	 *            the gestionnaireDao to set
	 */
	public void setGestionnaireDao(IEditerDao gestionnaireDao) {
		this.gestionnaireDao = gestionnaireDao;
	}

}
