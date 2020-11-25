package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contrat")
public class Contrat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	public Date dateDebut;
	
	@Column(name="type_contrat")
	private String typeContrat;
	
	@Column(name="salaire")
	private float salaire;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="FK_EMP_ID")
	private Employe employe;
	
	public Contrat() {
		// TODO Auto-generated constructor stub
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", dateDebut=" + dateDebut + ", typeContrat=" + typeContrat + ", salaire="
				+ salaire + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Contrat(Long id, Date dateDebut, String typeContrat, float salaire) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}

	public Contrat(Date dateDebut, float salaire, String typeContrat, Employe employe) {
		super();
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
		this.employe = employe;
	}
	
	
	
}
