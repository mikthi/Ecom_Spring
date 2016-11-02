package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.adaming.dao.ICommanderDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;


@Service
@Transactional
public class ClientServiceImpl extends ConsulterServiceImpl implements ICommanderService {

	@Autowired
	ICommanderDao comDao;
	@Override
	public void passerCommande(Commande com) {
		comDao.passerCommande(com);
		
	}
	@Override
	public void enregistrerClient(Client cl) {
		comDao.enregistrerClient(cl);
		
	}

	
}
