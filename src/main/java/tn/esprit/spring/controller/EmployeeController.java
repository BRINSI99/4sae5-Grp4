package tn.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

 
import tn.spring.entities.Employee;
 
import tn.spring.entities.Send;
import tn.spring.entities.Statistique;
import tn.spring.services.EmployeeService;
import tn.spring.services.ISend;

 

@Controller
public class EmployeeController {
	
	 
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
	}
	 
	  
	
	@GetMapping("/barChart")
	public String getAllEmployee(Model model) {	
		
		 
		List<Employee> dataList = service.getAllEmployee();
		List<Employee> dataList1 = service.getAllEmployees();
		int s=0;
		 int m=0;
		 List<Integer> list1 = null;
		 List<Integer> list2 = null;
	for(Employee data : dataList) {
		 
	 		
		
		m++;
		
	}
	for(Employee data : dataList1) {
		 
		
		 
			 s++;
			
		
		 
	}
 	    list1 = Arrays.asList(m+20).stream().collect(Collectors.toList());
 	   list2 = Arrays.asList(s-m).stream().collect(Collectors.toList());
 	   list1.add(s-m+20);
	model.addAttribute("ag", list1);
	model.addAttribute("age", list1);
	 
	model.addAttribute("ref", list2);
	model.addAttribute("Enc", m);
	model.addAttribute("total", s);
	return "barChart";
	
	}
}
