package fr.adaming.dao;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;


public interface ICommanderDao {
	public void passerCommande(Commande com);
	
	public void enregistrerClient(Client cl);

}
