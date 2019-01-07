package fr.romain.gdc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.romain.gdc.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Student saved successfully, Student Details="+p);
	}

	@Override
	public void updateStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Student updated successfully, Student Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudent() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentList = session.createQuery("from Student").list();
		for(Student p : studentList){
			logger.info("Student List::"+p);
		}
		return studentList;
	}

	@Override
	public Student getStudentById(int ids) {
		Session session = this.sessionFactory.getCurrentSession();		
		Student p = (Student) session.load(Student.class, new Integer(ids));
		logger.info("Student loaded successfully, Student details="+p);
		return p;
	}

	@Override
	public void removeStudent(int ids) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(ids));
		if(null != p){
			session.delete(p);
		}
		logger.info("Student deleted successfully, Student details="+p);
	}
	
}
