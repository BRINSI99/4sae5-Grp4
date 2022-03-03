package tn.spring.services;

import java.util.Date;
import java.util.List;

 
import tn.spring.entities.Send;



public interface ISend {
 

    public	void addSms(Send p);
    List<Send> getAllSms();
 
	
 
	
	
}
