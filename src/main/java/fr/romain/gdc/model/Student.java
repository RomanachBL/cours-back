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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@Column(name="ids")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ids;
	private String noms;
	private String prenoms;
	
	@ManyToMany(targetEntity = SessionCours.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER )
	@JoinTable(name = "Inscription", 
				joinColumns = { @JoinColumn(name = "ids") }, 
				inverseJoinColumns = { @JoinColumn(name = "idsess") })
	private Set<SessionCours> inscSessions = new HashSet<SessionCours>();
	
	public Set<SessionCours> getInscSessions() {
		return inscSessions;
	}

	public void setInscSessions(Set<SessionCours> inscSessions) {
		this.inscSessions = inscSessions;
	}

	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}
	
	public String getNoms() {
		return noms;
	}

	public void setNoms(String noms) {
		this.noms = noms;
	}
	
	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	
	
}
