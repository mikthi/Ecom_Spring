package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
@Repository

public class ClientDaoImpl implements ICommanderDao {
	
	@Autowired
	private SessionFactory sf;

	


	@Override
	public void passerCommande(Commande com) {
		Session s = sf.getCurrentSession();
		s.save(com);

	}
	@Override
	public void enregistrerClient(Client cl) {
		Session s = sf.getCurrentSession();
		s.save(cl);

	}
	
	/** getters et setters */
	
	/**
	 * @param sf the sf to set
	 */
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}






}
