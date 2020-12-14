package com.epita.hbtp3.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epita.hbtp3.entity.Produit;

public class ProduitDaoPgImpl implements ProduitDao {

	public void create(Produit produit) {
		// TSession factory
		SessionFactory sessionfactory=DaoFactory.getSessionFactory();
		
		Session session=sessionfactory.openSession();
				session.beginTransaction();
		session.save(produit);
		session.getTransaction().commit();
		session.close();
				
	}
}
