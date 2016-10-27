package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

@Repository
public class ConsulterDaoImpl implements IConsulterDao {
	@Autowired
	private SessionFactory sf;


	@Override
	public Commande consulterCommande(int id_commande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> consulterTousLesProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> consulterToutesLesCategories() {
		// TODO Auto-generated method stub
		return null;
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
	
	/** getters et setters */
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


}
