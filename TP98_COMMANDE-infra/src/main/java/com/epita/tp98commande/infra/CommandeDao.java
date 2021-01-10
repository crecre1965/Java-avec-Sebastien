package com.epita.tp98commande.infra;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epita.tp98commande.domaine.Client;
import com.epita.tp98commande.domaine.Commande;

public interface CommandeDao extends CrudRepository<Commande, Long>{
	public List<Commande>findByClient(Client client);
	
	

}
