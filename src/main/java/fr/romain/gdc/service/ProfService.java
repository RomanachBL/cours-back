package fr.romain.gdc.service;

import java.util.List;

import fr.romain.gdc.model.Prof;
import fr.romain.gdc.model.SessionCours;

public interface ProfService {
	
	public void addProf(Prof p);
	public void updateProf(Prof p);
	public List<Prof> listProf();
	public Prof getProfById(int idp);
	public void removeProf(int idp);

	public void addSession(SessionCours p);
	public void removeSession(int idsess);
}
