package fr.enseirb.persistance.projet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	public static final SessionFactory sessionFactory;
	static {
	try {
	// Cr�ation de la SessionFactory � partir de hibernate.cfg.xml
	sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	} catch (Throwable ex) {
	// Make sure you log the exception, as it might be swallowed
	System.err.println("Initial SessionFactory creation failed." + ex);
	throw new ExceptionInInitializerError(ex);
	}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
