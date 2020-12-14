package com.epita.hbtp3.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoFactory {
	private static SessionFactory sessionFactory;

	public static ProduitDao createProduitDAO() {
		return new ProduitDaoPgImpl();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionFactory;
	}
}
