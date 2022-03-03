package tn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Employee;
import tn.spring.entities.FeedBack;
import tn.spring.entities.Statistique;

@Repository
public interface StaistiqueRepository extends JpaRepository<Statistique, Integer> {

	Statistique findByEncours(int id);
   
}
