package fr.romain.gdc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cours")
public class Cours {
	@Id
	@Column(name="idc")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idc;
	private String titre;
	private String resume;
	private String competences;
	
	@OneToMany(mappedBy="unCours", fetch = FetchType.EAGER)
	private Set<SessionCours> sessions;
	
	@ManyToMany(mappedBy = "speCours")
	private Set<Prof> lesProfs;
	
	public Set<Prof> getLesProfs() {
		return lesProfs;
	}

	public void setLesProfs(Set<Prof> lesProfs) {
		this.lesProfs = lesProfs;
	}
	
	public Set<SessionCours> getSessions() {
		return sessions;
	}

	public void setSessions(Set<SessionCours> sessions) {
		this.sessions = sessions;
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}
	
	@Override
	public String toString(){
		return "idc="+idc+", titre="+titre+", resume="+resume+"competences"+competences;
	}
	
}