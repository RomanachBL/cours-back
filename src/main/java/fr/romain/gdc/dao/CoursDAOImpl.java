package fr.romain.gdc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.romain.gdc.model.Cours;

@Repository
public class CoursDAOImpl implements CoursDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ProfDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addCours(Cours p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Cours saved successfully, Cours Details="+p);
	}

	@Override
	public void updateCours(Cours p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Cours updated successfully, Cours Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cours> listCours() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cours> CoursList = session.createQuery("from Cours").list();
		for(Cours p : CoursList){
			logger.info("Cours List::"+p);
		}
		return CoursList;
	}

	@Override
	public Cours getCoursById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Cours p = (Cours) session.load(Cours.class, new Integer(id));
		logger.info("Cours loaded successfully, Cours details="+p);
		return p;
	}
	
	@Override
	public void removeCours(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cours p = (Cours) session.load(Cours.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Cours deleted successfully, Cours details="+p);
	}

}
