package com.epita.tp98commande.appli;

import java.util.List;

import com.epita.tp98commande.domaine.Client;

public interface ClientService {
	public long creer(Client client);
	public Client chercherClient(long id);
	public List<Client> listeClient();

}
