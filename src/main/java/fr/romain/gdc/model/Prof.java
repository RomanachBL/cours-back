package fr.romain.gdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
