package tn.esprit.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Timesheet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TimesheetsPD timesheets;
	
	@ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
	private Mission mission;
	
	@ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
	private Employe employe;
	
	
	private boolean isValide;
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}



	public TimesheetsPD getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(TimesheetsPD timesheets) {
		this.timesheets = timesheets;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	
}
