package tn.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Employee;
import tn.spring.repository.EmployeeRepository;
import tn.spring.repository.StaistiqueRepository;

 

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private StaistiqueRepository rep;
	
	public String saveEmployee(Employee employee)
	{
		repository.save(employee);
		 
		return "saved Employee Resource";
	}
	
	public List<Employee> getAllEmployee()
	{
		return repository.findByName("Encours");
	}
	public List<Employee> getAllEmployees()
	{
		return repository.findAll();
	}
	public List<Employee> getAllEmployeees()
	{
		return repository.findByName("Non");
	}
	 
	public List<Employee> aMethodNameOrSomething()
	{
		return repository.findAll();
	}
}
