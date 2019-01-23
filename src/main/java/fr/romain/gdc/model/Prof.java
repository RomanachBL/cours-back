package fr.romain.gdc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Prof")
public class Prof {
	@Id
	@Column(name="idp")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idp;
	private String nomp;
	private String prenomp;
	
	@OneToMany(mappedBy="unProf", fetch = FetchType.EAGER)
	private Set<SessionCours> sessions = new HashSet<SessionCours>();;

	@ManyToMany(targetEntity = Cours.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER )
	@JoinTable(name = "ListeSpe", 
				joinColumns = { @JoinColumn(name = "idp") }, 
				inverseJoinColumns = { @JoinColumn(name = "idc") })
	private Set<Cours> speCours;
	
	
	public Set<Cours> getSpeCours() {
		return speCours;
	}

	public void setSpeCours(Set<Cours> speCours) {
		this.speCours = speCours;
	}

	public Set<SessionCours> getSessions() {
		return sessions;
	}

	public void setSessions(Set<SessionCours> sessions) {
		this.sessions = sessions;
	}
	
	
	
	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}
	
	public String getNomp() {
		return nomp;
	}

	public void setNomp(String nomp) {
		this.nomp = nomp;
	}
	
	public String getPrenomp() {
		return prenomp;
	}

	public void setPrenomp(String prenomp) {
		this.prenomp = prenomp;
	}
	
	@Override
	public String toString(){
		return "idp="+idp+", nomp="+nomp+", prenomp="+prenomp;
	}
	
}
