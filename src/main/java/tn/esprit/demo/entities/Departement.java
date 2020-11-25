package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name_dep")
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER )
	private Set<Employe> employe;
	
	@ManyToOne
	private Entreprise entreprise;
	
	@OneToMany(cascade =CascadeType.ALL , mappedBy="departement")
	private Set<Mission> missions;
	@Override
	public String toString() {
		return "Departement [id=" + id + ", name=" + name + ", employe=" + employe + ", entreprise=" + entreprise
				+ ", missions=" + missions + "]";
	}

	public Departement( String name, Entreprise entreprise) {
		super();
	
		this.name = name;
		this.entreprise = entreprise;

	}
	public Departement() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Departement(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Departement( String name) {
		this.name = name;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(Set<Employe> employe) {
		this.employe = employe;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Set<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
}
