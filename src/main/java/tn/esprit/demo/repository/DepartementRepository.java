package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.demo.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long>{

}
