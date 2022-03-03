package tn.spring.services;

import java.util.List;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Company;
import tn.spring.entities.FeedBack;
import tn.spring.entities.Send;
import tn.spring.repository.CompanyRepository;
import tn.spring.repository.FeedBackRepository;
import tn.spring.repository.SendRepository;



 

 

@Service
public class SendImpl implements ISend {
	 
	@Autowired
	SendRepository comrep;
	
 
	  
 



	@Override
	public void addSms(Send p) {
		  
		 comrep.save(p);
	}







	@Override
	public List<Send> getAllSms()
	{
		return comrep.findAll();
	}

	 
	 
 
 
	
	
	
	
	
	

	
	
}