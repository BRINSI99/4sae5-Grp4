package tn.spring.services;

import java.util.List;

 
import tn.spring.entities.Employee;

public interface IEmployeeService {
	  Employee saveEmployee(Employee employee ,int id);
	  void st(Employee c);
}
