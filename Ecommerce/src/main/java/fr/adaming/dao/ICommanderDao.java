package fr.adaming.dao;

import fr.adaming.model.Client;
import fr.adaming.model.Panier;


public interface ICommanderDao {
	public void enregistrerClient(Client cl);
	public void passerCommande(Panier panier);

}
