package tn.esprit.demo.repository;

import java.util.List;

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
}
