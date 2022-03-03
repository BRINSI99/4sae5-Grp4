package tn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.spring.entities.Employee;

 

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	 List<Employee> findByName( String a);
	 
	@Query("SELECT Distinct name,COUNT(u) FROM Employee u WHERE u.name=:Encours")
	 List<Long> aMethodNameOrSomething();

 
	 

}
