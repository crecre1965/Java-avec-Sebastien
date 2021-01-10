package com.epita.tp98commande.infra;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epita.tp98commande.domaine.Produit;

public interface ProduitDao extends CrudRepository<Produit, Long>{
	public List<Produit> findAllByOrderByNameAsc();
	public List<Produit> findAllByOrderByPriceAsc();

}
