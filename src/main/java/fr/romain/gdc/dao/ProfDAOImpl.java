package fr.romain.gdc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.romain.gdc.model.Prof;

@Repository
public class ProfDAOImpl implements ProfDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ProfDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addProf(Prof p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Prof saved successfully, Prof Details="+p);
	}

	@Override
	public void updateProf(Prof p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Prof updated successfully, Prof Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prof> listProf() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Prof> ProfList = session.createQuery("from Prof").list();
		for(Prof p : ProfList){
			logger.info("Prof List::"+p);
		}
		return ProfList;
	}

	@Override
	public Prof getProfById(int idp) {
		Session session = this.sessionFactory.getCurrentSession();		
		Prof p = (Prof) session.load(Prof.class, new Integer(idp));
		logger.info("Prof loaded successfully, Prof details="+p);
		return p;
	}
	
	@Override
	public void removeProf(int idp) {
		Session session = this.sessionFactory.getCurrentSession();
		Prof p = (Prof) session.load(Prof.class, new Integer(idp));
		if(null != p){
			session.delete(p);
		}
		logger.info("Prof deleted successfully, Prof details="+p);
	}
	
	
}
