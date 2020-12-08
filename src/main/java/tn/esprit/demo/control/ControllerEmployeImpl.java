package tn.esprit.demo.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.demo.entities.Employe;
import tn.esprit.demo.entities.Role;
import tn.esprit.demo.services.IEmployeService;

@Scope(value="session")
@Controller(value="employeController")
@ELBeanName(value="employeController")
@Join(path="/", to="/login.jsf")
public class ControllerEmployeImpl {

	
	@Autowired
	IEmployeService employeService;
	
	private String login ;
	private String password;
	private Employe employe;
	private Boolean loggedIn;
	private Employe authenticatedUser;
	private String prenom;
	private String nom;
	private String email;
	private boolean isActif;
	private Role role;
	private List<Employe>employes;
	private int employeIdToBeUpdated;
	
	private float salaire;
	
	private Date daterecrutement;
	
	public int getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(int employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Employe> getEmployes() {
		employes = employeService.getAllEmployes();
		return employes;
		}

	public void removeEmploye(int employeId)
	{
	employeService.deleteEmployeById(employeId);
	}
	public boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(boolean isActif) {
		this.isActif = isActif;
	}
	public String getPassword() {
		return password;
	}
	public Employe getAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(Employe authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActif() {
		return isActif;
	}
	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public IEmployeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(IEmployeService employeService) {
		this.employeService = employeService;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Role[] getRoles() { return Role.values(); }
	public void setPassword(String password) {
		this.password = password;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String doLogin(){
		String navigateTo="null";
		
		authenticatedUser= employeService.authenticate(login, password);
		if(authenticatedUser != null && authenticatedUser.getRole() == Role.administrateur)
		
		//Employe employe=employeService.authenticate(login, password);
		//if (employe != null && employe.getRole() == Role.administrateur)
		{
			navigateTo ="/pages/admin/welcome.xhtml?faces-redirect=true";
			loggedIn=true;
			
		}
		else {
			FacesMessage facesMessage= new FacesMessage("Login failed : verifier votre login et mot de passe try again !");
				FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}
	public String doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
	
	
	public void addEmploye() {
		employeService.addOrUpdateEmploye(new Employe(email,isActif,prenom,nom,role,password,salaire,daterecrutement));
		}
	
	public void updateEmploye()
	{ 
		employeService.addOrUpdateEmploye(new Employe((long) employeIdToBeUpdated,email,isActif,prenom,nom,role,password,salaire,daterecrutement)); 
	}
	
	public void displayEmploye(Employe empl)
	{
	this.setPrenom(empl.getPrenom());
	this.setNom(empl.getNom());
	this.setActif(empl.getIsActif());
	this.setEmail(empl.getEmail());
	this.setRole(empl.getRole());
	this.setPassword(empl.getPassword());
	this.setEmployeIdToBeUpdated(empl.getId().intValue());
	this.setSalaire(empl.getSalaire());
	this.setDaterecrutement(empl.getDate_recrutement());
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Date getDaterecrutement() {
		return daterecrutement;
	}

	public void setDaterecrutement(Date date_recrutement) {
		this.daterecrutement = date_recrutement;
	}
}
