package tn.esprit.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Departement;
import tn.esprit.demo.entities.Entreprise;
import tn.esprit.demo.repository.DepartementRepository;
import tn.esprit.demo.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceEmpl implements  IEntrepriseService{

	private static final Logger l = LogManager.getLogger(EntrepriseServiceEmpl.class);

	@Autowired
	EntrepriseRepository er;
	
	@Autowired
	DepartementRepository dr;
	
	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		er.save(entreprise);
         	int id= entreprise.getId().intValue();
		return id;
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		dr.save(dep);
		int id = dep.getId().intValue();
		return id;
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Departement dep= dr.findById((long) depId).get();
		Entreprise en= er.findById((long) entrepriseId).get();
		dep.setEntreprise(en);
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		
		Entreprise e= er.findById((long) entrepriseId).get();
		
		List<String> departements=  new ArrayList<>();
		
		for (Departement d: e.getDepartements()) {
			departements.add(d.getName());
		}
		l.info("department names : "+departements);	

		return departements;
	}

}
