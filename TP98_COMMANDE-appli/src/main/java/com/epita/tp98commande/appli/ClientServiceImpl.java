package com.epita.tp98commande.appli;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epita.tp98commande.domaine.Client;
import com.epita.tp98commande.infra.ClientDao;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientDao clientDao;

	@Transactional
	public long creer(Client client) {
		if (client.getAge()<18) {
			return -1;
		}
		clientDao.save(client);
		return client.getId();
	}

	public Client chercherClient(long id) {
//		if (clientDao.existsById(id)) {
//		client=clientDao.findById(id);
//		return client;	
		return null;
	}

	public List<Client> listeClient() {
		// TODO Auto-generated method stub
		return null;
	}

}
