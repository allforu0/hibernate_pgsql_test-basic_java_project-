package com.cubrid.hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import com.cubrid.nation;

public class HibernateUtil {
	private static org.hibernate.SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			 initSessionFactory();
		}
		return sessionFactory;
	}

	private static synchronized void initSessionFactory() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}