package tn.esprit.demo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Employe;
import tn.esprit.demo.entities.Entreprise;

public interface IEmployeService {
	public int ajouterEmploye(Employe employe);
	// public void affecterEmployeADepartement(int employeId, int depId);
	 public int ajouterContrat(Contrat contrat);
	 public void affecterContratAEmploye(int contratId, int employeId);
	 public String getEmployePrenomById(int employeId);
	 public long getNombreEmployeJPQL();
	 public List<String> getAllEmployeNamesJPQL();
	 public List<Employe> getAllEmployeByEntreprise(@Param("entreprise")Entreprise entreprise);
	 public Double getSalaireMoyenByDepartementId(@Param("depId")int departementId);
     public Employe authenticate(String login, String password);
     public int addOrUpdateEmploye(Employe employe);
     public List<Employe> getAllEmployes();
     public void deleteEmployeById(int employeId);
}
