package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.TravelPlanning;

public interface ITravelPlanningService {
	
	    List<TravelPlanning> getAllTravelPlanning();
	    
		TravelPlanning addTravelPlanning(TravelPlanning t);
		
		TravelPlanning updateTravelPlanning(TravelPlanning t);
		 
		TravelPlanning getTravelPlanningById(long Id);
		
	    void deleteTravelPlanningById(long Id);
	    
	  
	    
	    

}
