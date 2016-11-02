package fr.adaming.service;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public interface ICommanderService extends IConsulterService{


	public void passerCommande(Commande com);
	public void enregistrerClient(Client cl);
}
