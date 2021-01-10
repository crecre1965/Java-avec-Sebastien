package com.epita.tp98commande.infra;

import org.springframework.data.repository.CrudRepository;

import com.epita.tp98commande.domaine.Adress;

public interface AdresseDao extends CrudRepository<Adress,Long> {

}
