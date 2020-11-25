package tn.esprit.demo.services;

import java.util.List;

import tn.esprit.demo.entities.Departement;
import tn.esprit.demo.entities.Entreprise;

public interface IEntrepriseService {
	 public int ajouterEntreprise(Entreprise entreprise);
	 public int ajouterDepartement(Departement dep);
     public void affecterDepartementAEntreprise(int depId, int entrepriseId);
 public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
}
