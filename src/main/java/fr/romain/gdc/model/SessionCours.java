package fr.romain.gdc.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SessionCours")
public class SessionCours {
	
	@Id
	@Column(name="idsess")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsess;
	private Date datedeb;
	private int semaines;
	
	@ManyToOne
	@JoinColumn(name="idc", nullable=false )
	private Cours unCours;
	
	@ManyToOne
	@JoinColumn(name="idp", nullable=false)
	private Prof unProf;
	
	@ManyToMany(mappedBy = "inscSessions", fetch = FetchType.EAGER)
	private Set<Student> lesEtudiants = new HashSet<Student>();

	public SessionCours() {}
	
	public SessionCours(Cours unCours, Prof unProf, Date datedeb, int semaines) {
		super();
		this.unCours = unCours;
		this.unProf = unProf;
		this.datedeb = datedeb;
		this.semaines = semaines;
	}
	
	public Cours getUnCours() {
		return unCours;
	}

	public void setUnCours(Cours unCours) {
		this.unCours = unCours;
	}
	
	public int getIdsess() {
		return idsess;
	}



	public void setIdsess(int idsess) {
		this.idsess = idsess;
	}


	public Prof getUnProf() {
		return unProf;
	}

	public void setUnProf(Prof unProf) {
		this.unProf = unProf;
	}

	public Set<Student> getLesEtudiants() {
		return lesEtudiants;
	}

	public void setLesEtudiants(Set<Student> lesEtudiants) {
		this.lesEtudiants = lesEtudiants;
	}


	public Date getDatedeb() {
		return datedeb;
	}



	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}



	public int getSemaines() {
		return semaines;
	}



	public void setSemaines(int semaines) {
		this.semaines = semaines;
	}


}
