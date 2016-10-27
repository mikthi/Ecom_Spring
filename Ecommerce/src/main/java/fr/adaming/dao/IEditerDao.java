package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Categorie;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.Produit;


public interface IEditerDao  {
	public void ajouterProduit(Produit p);
	public void modifierProduit(Produit p);
	public void supprimerProduit(Produit p);
	public void ajouterCategorie(Categorie c);
	public void modifierCategorie(Categorie c);
	public void supprimerCategorie(Categorie c);
	public List<Gestionnaire> isExistGestionnaireDao(String nom, String prenom, String password);
}
