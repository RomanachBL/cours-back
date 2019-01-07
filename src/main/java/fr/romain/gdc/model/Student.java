package fr.romain.gdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Override
	public String toString(){
		return "ids="+ids+", noms="+noms+", prenoms="+prenoms;
	}
	
}
