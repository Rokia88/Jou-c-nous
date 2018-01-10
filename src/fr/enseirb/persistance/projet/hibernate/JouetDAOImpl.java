package fr.enseirb.persistance.projet.hibernate;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import fr.enseirb.persistance.projet.HibernateUtil;
import fr.enseirb.persistance.projet.Jouet;
import fr.enseirb.persistance.projet.JouetDAO;
import fr.enseirb.persistance.projet.JouetVideo;
import fr.enseirb.persistance.projet.Stock;

public class JouetDAOImpl implements JouetDAO {

	@Override
	public Jouet updateJouet(Jouet jouet) {
		// TODO Auto-generated method stub
			Session session =HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(jouet);
			session.getTransaction().commit();
			return jouet;
		}

	@Override
	public long getStockChaine(String type) {
		// TODO Auto-generated method stub
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Query query=session.createQuery("select sum(s.quantité) from Stock s where s.type=:param");
		query.setParameter("param", type);
		long stock=(Long) query.list().get(0);
		session.getTransaction().commit();
		return stock;
	}

	@Override
	public long getStockMagasin(String nameMag) {
		// TODO Auto-generated method stub
		
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("select sum(s.quantité) from Stock s where s.magasin.nom=:param");
		query.setParameter("param",nameMag);
		long stock=(Long) query.list().get(0);
		session.getTransaction().commit();
		return stock;
	}

	@Override
	public List<JouetVideo> selectJouetsVidéoSurCritère(String nomMag, String typeConsole) {
		// TODO Auto-generated method stub
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Jouet j where j.magasin.nom=:param1 and j.typeConsole=:param");
		query.setParameter("param1",nomMag);
		query.setParameter("param",typeConsole);
		List<JouetVideo> jouets=query.list();
		session.getTransaction().commit();		
		return jouets;
	}
	
}


