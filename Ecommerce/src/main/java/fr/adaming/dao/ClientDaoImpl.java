package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Panier;
@Repository

public class ClientDaoImpl implements ICommanderDao {
	
	@Autowired
	private SessionFactory sf;

	

	@Override
	public void enregistrerClient(Client cl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void passerCommande(Panier panier) {
		// TODO Auto-generated method stub

	}
	
	/** getters et setters */
	
	/**
	 * @param sf the sf to set
	 */
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


}
