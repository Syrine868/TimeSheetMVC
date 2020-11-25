package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Departement;
import tn.esprit.demo.entities.Employe;

@Repository
public interface EmpDepRepo extends JpaRepository<Departement, Employe>{

}
