package fr.romain.gdc.service;

import java.util.List;
import java.util.Set;

import fr.romain.gdc.model.SessionCours;
import fr.romain.gdc.model.Student;

public interface StudentService {
	
	public void addStudent(Student p);
	public void updateStudent(Student p);
	public List<Student> listStudent();
	public Student getStudentById(int ids);
	public void removeStudent(int ids);
	
	public Set<SessionCours> listSessions();
	public SessionCours getSessionById(int idsess);

}
