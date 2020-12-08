package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long>{

}
