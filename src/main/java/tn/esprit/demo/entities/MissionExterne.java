package tn.esprit.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mission")
public class MissionExterne extends Mission implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="mex_emailFacturation")
	private String emailFacturation;
	 
	@Column(name="taux_journalier_moyen_mex")
	private String tauxJournalierMoyen;

	@Override
	public String toString() {
		return "MissionExterne [emailFacturation=" + emailFacturation + ", tauxJournalierMoyen=" + tauxJournalierMoyen
				+ "]";
	}

	public String getEmailFacturation() {
		return emailFacturation;
	}

	public void setEmailFacturation(String emailFacturation) {
		this.emailFacturation = emailFacturation;
	}

	public String getTauxJournalierMoyen() {
		return tauxJournalierMoyen;
	}

	public void setTauxJournalierMoyen(String tauxJournalierMoyen) {
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

	

	
	
	public MissionExterne(Long id, String name, String description, Departement departement) {
		super(id, name, description, departement);
		// TODO Auto-generated constructor stub
	}

	public MissionExterne(Long id, String name, String description, Departement departement, String emailFacturation,
			String tauxJournalierMoyen) {
		super(id, name, description, departement);
		this.emailFacturation = emailFacturation;
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

	public MissionExterne() {
		// TODO Auto-generated constructor stub
	}
}

