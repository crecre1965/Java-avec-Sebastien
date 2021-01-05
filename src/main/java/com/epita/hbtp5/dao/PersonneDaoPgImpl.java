package com.epita.hbtp5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epita.hbtp5.entity.Personne;

public class PersonneDaoPgImpl implements PersonneDao {

	public void create(Personne personne) {
		// Session factory
		SessionFactory sessionFactory = DaoFactory.getSessionFactoryy();

		// Create
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personne);
		session.getTransaction().commit();
		session.close();

	}

}
