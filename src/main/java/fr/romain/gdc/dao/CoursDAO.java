package fr.romain.gdc.dao;

import java.util.List;

import fr.romain.gdc.model.Cours;

public interface CoursDAO {
	
	public void addCours(Cours p);
	public void updateCours(Cours p);
	public List<Cours> listCours();
	public Cours getCoursById(int id);
	public void removeCours(int id);

}
