package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employe")
public class Employe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="email_emp")
	private String email;
	
	@Column (name="isactif")
	private int isActif;
	
	@Column(name="first_name")
	private String prenom;
	
	@Column(name="last_name")
	private String nom;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsActif() {
		return isActif;
	}

	public void setIsActif(int isActif) {
		this.isActif = isActif;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", email=" + email + ", isActif=" + isActif + ", prenom=" + prenom + ", nom=" + nom
				+ ", role=" + role + "]";
	}


	
	
	public Employe(Long id, String email, int isActif, String prenom, String nom, Role role, String password) {
		super();
		this.id = id;
		this.email = email;
		this.isActif = isActif;
		this.prenom = prenom;
		this.nom = nom;
		this.role = role;
		this.password = password;
	}

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Employe(String email, int isActif, String prenom, String nom, Role role) {
		super();
		this.email = email;
		this.isActif = isActif;
		this.prenom = prenom;
		this.nom = nom;
		this.role = role;
	}

	public Employe() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToOne(mappedBy="employe")
	private Contrat contrat;

	
	@ManyToMany( mappedBy="employe",cascade=CascadeType.ALL )
	private Set<Departement> departements;

 
	@OneToMany(mappedBy="employe")
	private List<Timesheet> timesheets;
	
}
