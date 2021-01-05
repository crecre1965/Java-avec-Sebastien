package com.epita.hbtp5.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoFactory {
	private static SessionFactory sessionFactory;
	
	public static PersonneDao createPersonneDao() {
		return new PersonneDaoPgImpl();
			
	}
	
	public static SessionFactory getSessionFactoryy() {
		if (sessionFactory==null) {
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

}
