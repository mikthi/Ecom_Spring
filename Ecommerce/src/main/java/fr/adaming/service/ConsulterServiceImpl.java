package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConsulterDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

@Service
@Transactional
public class ConsulterServiceImpl implements IConsulterService {
	
	@Autowired
	IConsulterDao consulterDao;	

	@Override
	public Commande consulterCommande(int id_commande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> consulterTousLesProduits() {
		return consulterDao.consulterTousLesProduits();
	}

	@Override
	public List<Categorie> consulterToutesLesCategories() {
		return consulterDao.consulterToutesLesCategories();
	}

	@Override
	public List<Produit> consulterLesProduitsParCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit consulterProduitSelectionne(int id_produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> chercherProduitsParMotCle(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie consulterCategorieParId(int id_categorie) {
		return consulterDao.consulterCategorieParId(id_categorie);
	}

	/**
	 * Setter
	 */
	/**
	 * @param consulterDao the consulterDao to set
	 */
	public void setConsulterDao(IConsulterDao consulterDao) {
		this.consulterDao = consulterDao;
	}

	@Override
	public Produit consulterProduitParId(int id_produit) {
		return consulterDao.consulterProduitParId(id_produit);
	}
	
	

}
