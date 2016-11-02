package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

public interface IConsulterDao {
	
	public Commande consulterCommande(int id_commande);

	public List<Produit> consulterTousLesProduits();

	public List<Categorie> consulterToutesLesCategories();

	public List<Produit> consulterLesProduitsParCategorie(int id_categ);

	public Produit consulterProduitSelectionne(int id_produit);

	public List<Produit> chercherProduitsParMotCle(String motCle);
	
	public Categorie consulterCategorieParId(int id_categorie);

	public Produit consulterProduitParId(int id_produit);
}
