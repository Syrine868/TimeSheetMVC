package tn.esprit.demo.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{
	  @Query(value = "SELECT * FROM employe ", nativeQuery = true)
	  List<Employe> findByPrenom();

	  @Query(value = "select count(*) from Employe ", nativeQuery = true)
	  double countemployes();
	  
	 @Query(value="Select "
				+ "DISTINCT emp from Employe emp "
				+ "join emp.departements dps "
				+ "join dps.entreprise entrep "
				+ "where entrep=:entreprise", nativeQuery=true)
	 List<Employe> getAllbyEntre();
	 
	 @Query(value="Select "
				+ "DISTINCT AVG(cont.salaire) from Contrat cont "
				+ "join cont.employe emp "
				+ "join emp.departements deps "
				+ "where deps.id=:depId", nativeQuery=true)
	 double getSalbyemp();
	
}
