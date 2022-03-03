package tn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
import tn.spring.entities.Company;
import tn.spring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
 }
