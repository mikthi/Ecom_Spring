package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Categorie;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

@Service
@Transactional
public class ConsulterServiceImpl implements IConsulterService {
	

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

}
