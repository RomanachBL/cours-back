package fr.romain.gdc.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.romain.gdc.dao.StudentDAO;
import fr.romain.gdc.model.Student;
import fr.romain.gdc.model.SessionCours;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional
	public void addStudent(Student p) {
		this.studentDAO.addStudent(p);
	}

	@Override
	@Transactional
	public void updateStudent(Student p) {
		this.studentDAO.updateStudent(p);
	}

	@Override
	@Transactional
	public List<Student> listStudent() {
		return this.studentDAO.listStudent();
	}

	@Override
	@Transactional
	public Student getStudentById(int ids) {
		return this.studentDAO.getStudentById(ids);
	}

	@Override
	@Transactional
	public void removeStudent(int ids) {
		this.studentDAO.removeStudent(ids);
	}
	
	@Override
	@Transactional
	public Set<SessionCours> listSessions(){
		return this.studentDAO.listSessions();
	}
	
	@Override
	@Transactional
	public SessionCours getSessionById(int idsess) {
		return this.studentDAO.getSessionById(idsess);
	}

	
}
