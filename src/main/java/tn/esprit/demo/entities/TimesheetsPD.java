package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TimesheetsPD implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idMission;
	
	private int idEmploye;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	


	public TimesheetsPD(int idEmploye, Date dateDebut, Date dateFin) {
		super();
		this.idEmploye = idEmploye;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public TimesheetsPD() {
		super();
	}

	public TimesheetsPD(int idMission, int idEmploye, Date dateDebut, Date dateFin) {
		super();
		this.idMission = idMission;
		this.idEmploye = idEmploye;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getIdMission() {
		return idMission;
	}
}
