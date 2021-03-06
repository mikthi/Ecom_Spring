package fr.adaming.dao;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IEditerDao {
	
	public void ajouterProduit(Produit p);

	public void modifierProduit(Produit p);

	public void supprimerProduit(int id_produit);

	public void ajouterCategorie(Categorie c);

	public void modifierCategorie(Categorie c);

	public void supprimerCategorie(int id_categorie);
}
