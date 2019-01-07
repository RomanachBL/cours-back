package fr.romain.gdc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.romain.gdc.dao.ProfDAO;
import fr.romain.gdc.model.Prof;

@Service
public class ProfServiceImpl implements ProfService{
	
	private ProfDAO ProfDAO;

	public void setProfDAO(ProfDAO ProfDAO) {
		this.ProfDAO = ProfDAO;
	}

	@Override
	@Transactional
	public void addProf(Prof p) {
		this.ProfDAO.addProf(p);
	}

	@Override
	@Transactional
	public void updateProf(Prof p) {
		this.ProfDAO.updateProf(p);
	}

	@Override
	@Transactional
	public List<Prof> listProf() {
		return this.ProfDAO.listProf();
	}

	@Override
	@Transactional
	public Prof getProfById(int idp) {
		return this.ProfDAO.getProfById(idp);
	}

	@Override
	@Transactional
	public void removeProf(int idp) {
		this.ProfDAO.removeProf(idp);
	}
	
}
