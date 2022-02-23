package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Company;
import tn.esprit.spring.entity.Employee;

public interface IEmployeeService {
	
	Employee addEmployee(Employee e);
	
	List<Employee> ShowAllUniOff();
	
    int DeleteEmployee(int X);
	
	Employee ModifyEpmloyee(Employee e,int x);

}
