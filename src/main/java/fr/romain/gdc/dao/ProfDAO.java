package fr.romain.gdc.dao;

import java.util.List;

import fr.romain.gdc.model.Prof;
import fr.romain.gdc.model.SessionCours;

public interface ProfDAO {
	
	public void addProf(Prof p);
	public void updateProf(Prof p);
	public List<Prof> listProf();
	public Prof getProfById(int id);
	public void removeProf(int id);
	
	public void addSession(SessionCours p);
	public void removeSession(int idsess);

}
