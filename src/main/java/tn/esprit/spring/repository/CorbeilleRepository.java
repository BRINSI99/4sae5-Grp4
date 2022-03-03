package tn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Corbeille;

 
 
@Repository
public interface CorbeilleRepository extends JpaRepository<Corbeille, String> {

	 

}