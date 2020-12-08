package tn.esprit.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Employe;
import tn.esprit.demo.entities.Entreprise;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{
	 
	@Query(value = "SELECT * FROM employe ", nativeQuery = true)
	public  List<Employe> findByPrenom();

	  @Query(value = "select count(*) from Employe ", nativeQuery = true)
	  public  double countemployes();
	  
	 @Query("Select "
				+ "DISTINCT e from Employe e "
				+ "join e.departements dps "
				+ "join dps.entreprise entrep "
				+ "where entrep=:entreprise")
	public List<Employe> getAllbyEntre(@Param("entreprise")Entreprise entreprise);
	 
	 @Query("Select "
				+ "DISTINCT AVG(cont.salaire) from Contrat cont "
				+ "join cont.employe emp "
				+ "join emp.departements deps "
				+ "where deps.id=:departements_id")
	 public double getSalbyemp(@Param("departements_id")int departements_id);
	
	 
	 @Query("select e from Employe e where e.email=:email_emp and e.password=:password ")
	 public Employe getUserByEmailAndPassword(@Param("email_emp")String login,@Param("password") String password);
	 
}
