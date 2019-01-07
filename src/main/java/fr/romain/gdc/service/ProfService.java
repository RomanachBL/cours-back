package fr.romain.gdc.service;

import java.util.List;

import fr.romain.gdc.model.Prof;

public interface ProfService {
	
	public void addProf(Prof p);
	public void updateProf(Prof p);
	public List<Prof> listProf();
	public Prof getProfById(int idp);
	public void removeProf(int idp);

}
