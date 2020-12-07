package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Entreprise;
@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
