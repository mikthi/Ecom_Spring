package fr.adaming.service;

import fr.adaming.model.Client;
import fr.adaming.model.Panier;


public interface ICommanderService extends IConsulterService{

	public void enregistrerClient(Client cl);

	public void passerCommande(Panier panier);
}
