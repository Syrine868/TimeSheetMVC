package tn.esprit.demo.services;

import java.util.List;

import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Employe;

public interface IEmployeService {
	public int ajouterEmploye(Employe employe);
	 public void affecterEmployeADepartement(int employeId, int depId);
	 public int ajouterContrat(Contrat contrat);
	 public void affecterContratAEmploye(int contratId, int employeId);
	 public String getEmployePrenomById(int employeId);
	 public long getNombreEmployeJPQL();
	 public List<String> getAllEmployeNamesJPQL();
	
}
