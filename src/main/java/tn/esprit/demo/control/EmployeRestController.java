package tn.esprit.demo.control;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Employe;
import tn.esprit.demo.services.IEmployeService;



@RestController
public class EmployeRestController {

	
	@Autowired
	IEmployeService ies;
	
	@PostMapping("/add-employe")
	@ResponseBody
	public int addEmp (@RequestBody Employe employe){
		return ies.ajouterEmploye(employe);
	}
	
	@PostMapping("/add-contrat")
	@ResponseBody
	public int ajoutContrat (@RequestBody Contrat contrat){
		return ies.ajouterContrat(contrat);
	}
	
	@PostMapping("/affecterContratEmp/{id}/{id}")
	@ResponseBody
	public void affecterContratEmp (@PathVariable("id")int contratId,@PathVariable("id")int  employeId){
			ies.affecterContratAEmploye(contratId, employeId);
	}
	@PostMapping("/affecterdepemp/{departements_id}/{employe_id}")
	@ResponseBody
	public void affecterDepEmp (@PathVariable("departements_id")int contratId,@PathVariable("employe_id")int  employeId){
			ies.affecterContratAEmploye(contratId, employeId);
	}
	
	@GetMapping("/afficherPrenomById/{first_name}")
	@ResponseBody
	public String getEmployePrenomByIdC(@PathVariable("first_name")int employeId) {
		return ies.getEmployePrenomById(employeId);
	}
	
}
