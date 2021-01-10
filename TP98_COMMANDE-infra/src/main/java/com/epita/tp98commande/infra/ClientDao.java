package com.epita.tp98commande.infra;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epita.tp98commande.domaine.Client;

public interface ClientDao extends CrudRepository<Client, Long>{
	public List<Client> findAllByOrderByLastname();
	public List<Client> findByLastname(String lastname);
	
	

}
