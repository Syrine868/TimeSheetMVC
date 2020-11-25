package tn.esprit.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Departement;
import tn.esprit.demo.entities.Employe;
import tn.esprit.demo.repository.ContratRepository;
import tn.esprit.demo.repository.DepartementRepository;
import tn.esprit.demo.repository.EmpDepRepo;
import tn.esprit.demo.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService{

	private static final Logger l = LogManager.getLogger(EntrepriseServiceEmpl.class);

	@Autowired
	EmployeRepository empr;
	
	@Autowired
	ContratRepository cr;
	
	@Autowired 
	DepartementRepository dr;
	
	
	@Autowired
	EmpDepRepo empdepr;
	
	@Override
	public int ajouterEmploye(Employe employe) {
		empr.save(employe);
		return employe.getId().intValue();
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		Departement d= dr.findById((long)depId).get();
		Employe e=empr.findById((long)employeId).get();
		
		if(d.getEmploye() == null){
			List<Employe> employes = new ArrayList<>();
			employes.add(e);
			d.setEmploye((Set<Employe>) employes);
		}
		else
		{
			d.getEmploye().add(e);
		}
		empdepr.save(d);
	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		cr.save(contrat);
		return contrat.getId().intValue();
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat c=cr.findById((long)contratId).get();
		Employe emp=empr.findById((long)employeId).get();
		
		c.setEmploye(emp);
		
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		Employe employe = empr.findById( (long) employeId).get();
		l.info("Prenom employe by id : "+employe.getPrenom());
		return employe.getPrenom();
		}

	@Override
	public long getNombreEmployeJPQL() {
		l.info("Nombre"+empr.countemployes());
		return (long) empr.countemployes();
	}

    @Transactional
	public List<String> getAllEmployeNamesJPQL() {
		List<Employe> employes=(List<Employe>) empr.findByPrenom();
		
		List<String> employeNames = new ArrayList<>();
		for(Employe employe : employes){
			employeNames.add(employe.getNom());
		}
		l.info("getAllEmployeNamesJPQL: "+employeNames);
		
		return employeNames;
	}

}
