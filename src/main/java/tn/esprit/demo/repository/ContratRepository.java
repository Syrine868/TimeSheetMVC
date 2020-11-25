package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Contrat;


@Repository
public interface ContratRepository  extends JpaRepository<Contrat, Long>{

}
