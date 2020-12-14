package com.epita.tp2.app;


import com.epita.tp2.dao.ProduitDao;
import com.epita.tp2.dao.ProduitDaoPgImpl;
import com.epita.tp2.entity.Produit;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produit produit = new Produit();
		produit.setNom("clavier");
		produit.setPrix(50);
		
		ProduitDao dao = new ProduitDaoPgImpl();
		dao.create(produit);
		
	}

}
