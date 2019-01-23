package fr.romain.gdc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.romain.gdc.dao.CoursDAO;
import fr.romain.gdc.model.Cours;
import fr.romain.gdc.model.SessionCours;

@Service
public class CoursServiceImpl implements CoursService {
	
	private CoursDAO CoursDAO;

	public void setCoursDAO(CoursDAO CoursDAO) {
		this.CoursDAO = CoursDAO;
	}

	@Override
	@Transactional
	public void addCours(Cours p) {
		this.CoursDAO.addCours(p);
	}

	@Override
	@Transactional
	public void updateCours(Cours p) {
		this.CoursDAO.updateCours(p);
	}

	@Override
	@Transactional
	public List<Cours> listCours() {
		return this.CoursDAO.listCours();
	}

	@Override
	@Transactional
	public Cours getCoursById(int id) {
		return this.CoursDAO.getCoursById(id);
	}

	@Override
	@Transactional
	public void removeCours(int id) {
		this.CoursDAO.removeCours(id);
	}
	
	@Override
	@Transactional
	public SessionCours getSessionById(int id) {
		return this.CoursDAO.getSessionById(id);
	}


}
