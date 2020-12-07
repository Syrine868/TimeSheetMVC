package tn.esprit.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entities.Departement;
import tn.esprit.demo.entities.Entreprise;
import tn.esprit.demo.services.IEntrepriseService;

@RestController
public class EntrepriseRestControl {
	
	@Autowired 
	IEntrepriseService ies;
	
	@PostMapping("/add-entreprise")
	@ResponseBody
	public int addEntreprise (@RequestBody Entreprise entreprise){
		return ies.ajouterEntreprise(entreprise);
	}
	
	
	@PostMapping("/add-departement")
	@ResponseBody
	public int addDepartement (@RequestBody Departement dep){
		return ies.ajouterDepartement(dep);
	}
	
	
	@PostMapping("/affecterDepEntreprise/{dep-id}/{entreprise-id}")
	@ResponseBody
	public void affecterdepartEntre(@PathVariable("dep-id")int depid, @PathVariable("entreprise-id")int entrepriseid){
		ies.affecterDepartementAEntreprise(depid, entrepriseid);
	}

	@GetMapping("/departementsByname/{entreprise-id}")
	@ResponseBody
	public List<String> retrievedepByName(@PathVariable("entreprise-id")int entrepriseId)
	{
		return ies.getAllDepartementsNamesByEntreprise(entrepriseId);
	}
	
}
