package com.epita.tp98commande.appli;

import java.util.List;

import com.epita.tp98commande.domaine.Client;
import com.epita.tp98commande.domaine.Commande;

public interface CommandeService {
	public Commande creer(Commande commande);
	public List<Commande>findByClient(Client client);
}
