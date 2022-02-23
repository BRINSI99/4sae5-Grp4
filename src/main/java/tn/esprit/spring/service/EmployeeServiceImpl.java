package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Company;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeerepository;
	
	
	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		
		return employeerepository.save(e) ;
	}

	@Override
	public List<Employee> ShowAllUniOff() {
		List<Employee> ListUniOff = employeerepository.findAll();
        return ListUniOff;
	}

	@Override
	public int DeleteEmployee(int X) {
		// TODO Auto-generated method stub
		employeerepository.deleteById(X);
        return X;
	}

	@Override
	public Employee ModifyEpmloyee(Employee E, int x) {
		// TODO Auto-generated method stub
		Optional<Employee> opEpmloyee = employeerepository.findById(x);
		if (opEpmloyee.isPresent()) {
			Employee e = opEpmloyee.get();
			e.setAge(e.getAge());
						
			//c.setDomains(C.getDomains());
			e.setCin(E.getCin());
			e.setFirstName(E.getFirstName());
			e.setLastName(E.getLastName());
			employeerepository.save(e);
			return e;
		}
		else {
			return null;
		}
	}

}
