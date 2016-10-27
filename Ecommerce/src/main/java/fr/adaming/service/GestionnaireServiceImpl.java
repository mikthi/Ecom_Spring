package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEditerDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.Produit;

@Service
@Transactional
public class GestionnaireServiceImpl implements IEditerDao {

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

}
