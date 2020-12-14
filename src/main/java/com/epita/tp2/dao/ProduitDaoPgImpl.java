package com.epita.tp2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.epita.tp2.entity.Produit;

public class ProduitDaoPgImpl implements ProduitDao {
	public void create(Produit produit) {
		//SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Session
		Session session=factory.openSession();
		//Transaction
		session.beginTransaction();
		session.save(produit);
		session.getTransaction().commit();
		session.close();
	}



}
