package tn.esprit.demo;



import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.demo.entities.Departement;

import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Employe;
import tn.esprit.demo.entities.Entreprise;
import tn.esprit.demo.entities.Role;
import tn.esprit.demo.repository.EmployeRepository;
import tn.esprit.demo.services.IEmployeService;
import tn.esprit.demo.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeSheetMvcApplicationTests {

	
	@Autowired
	IEntrepriseService ies;
	
	@Autowired
	IEmployeService iemps;
	
	@Autowired
	EmployeRepository er;
	
	@Test
	public void contextLoads() {
	Entreprise entreprise=  new Entreprise( "X7", "Tunis");
    ies.ajouterEntreprise(entreprise);
	Departement dep = new Departement( "X6",entreprise);
	//ies.ajouterDepartement(dep);
	//ies.affecterDepartementAEntreprise(dep.getId().intValue(),entreprise.getId().intValue());
	
	//ies.getAllDepartementsNamesByEntreprise(entreprise.getId().intValue());
		
		//Employe employe=new Employe("yosra.arbi@ssiiconsulting.tn", 0, "Yosra", "Arbi", Role.chefDepartement);
		//Employe employe1=new Employe("syrine868@gmail.com", 1, "Jlassi", "Syrine", Role.ingénieur);
		//iemps.ajouterEmploye(employe);
		Contrat contrat = new Contrat(new Date(),900,"CDI", new Employe("syrine868@gmail.com", 1, "Jlassi", "Syrine", Role.ingénieur));
		//iemps.ajouterContrat(contrat);
		//iemps.affecterContratAEmploye(contrat.getId().intValue(), employe.getId().intValue());
	//	iemps.affecterEmployeADepartement(employe.getId().intValue(), dep.getId().intValue());
	//	iemps.getEmployePrenomById(employe.getId().intValue());
		//iemps.getAllEmployeNamesJPQL();
	//	iemps.getNombreEmployeJPQL();
		iemps.getAllEmployeByEntreprise(entreprise);
		//iemps.getSalaireMoyenByDepartementId(dep.getId().intValue());
		
	}

}
