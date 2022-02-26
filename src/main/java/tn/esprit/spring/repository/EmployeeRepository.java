package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
