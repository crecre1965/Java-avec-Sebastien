package com.epita.hbtp3.app;

import com.epita.hbtp3.dao.DaoFactory;
import com.epita.hbtp3.dao.ProduitDao;
import com.epita.hbtp3.entity.Produit;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produit produit = new Produit();
		produit.setNom("souris");
		produit.setPrix(25);
		ProduitDao dao = DaoFactory.createProduitDAO();
		dao.create(produit);

	}

}
