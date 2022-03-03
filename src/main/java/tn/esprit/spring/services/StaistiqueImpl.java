	package tn.spring.services;

import java.util.List;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Company;
import tn.spring.entities.Employee;
import tn.spring.entities.FeedBack;
import tn.spring.entities.Statistique;
import tn.spring.repository.CompanyRepository;
import tn.spring.repository.EmployeeRepository;
import tn.spring.repository.StaistiqueRepository;
 


 

 

@Service
public class StaistiqueImpl implements StatistiqueService {
	@Autowired
	StaistiqueRepository repository;
	@Autowired
	EmployeeRepository emp;
	 
	@Override
	public Statistique ADDSta(Statistique c,int id) {
		int x=0;
		Statistique s;
		for (int i=0;i<repository.findAll().size();i++)
		{
			x++;
		}
 		  if(x<2)
 		  {
 			    repository.save(new Statistique(0,"Encours"))  ;
 			   repository.save(new Statistique(0,"Non"))  ;
 		  }
 		  
	       
		return null;
	}
	  

	 

	  


	
 

 
	
	
	
	
	
	

	
	
}