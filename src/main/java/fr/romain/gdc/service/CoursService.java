package fr.romain.gdc.service;

import java.util.List;

import fr.romain.gdc.model.Cours;

public interface CoursService {
	
	public void addCours(Cours p);
	public void updateCours(Cours p);
	public List<Cours> listCours();
	public Cours getCoursById(int id);
	public void removeCours(int id);

}
