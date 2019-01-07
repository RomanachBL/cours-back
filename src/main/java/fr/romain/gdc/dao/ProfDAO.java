package fr.romain.gdc.dao;

import java.util.List;

import fr.romain.gdc.model.Prof;

public interface ProfDAO {
	
	public void addProf(Prof p);
	public void updateProf(Prof p);
	public List<Prof> listProf();
	public Prof getProfById(int idp);
	public void removeProf(int idp);

}
