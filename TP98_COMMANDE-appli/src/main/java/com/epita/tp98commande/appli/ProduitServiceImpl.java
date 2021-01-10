package com.epita.tp98commande.appli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epita.tp98commande.domaine.Produit;
import com.epita.tp98commande.infra.ProduitDao;
@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitDao produitDao;
	public void create(Produit p) {
		produitDao.save(p);

	}

}
