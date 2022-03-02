package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.SearchCritere;
import tn.esprit.spring.entity.TravelExcel;
import tn.esprit.spring.entity.TravelPlanning;

import tn.esprit.spring.service.TravelPlanningServiceImp;

@RestController
public class TravelPlanningController {
	
	@Autowired
	TravelPlanningServiceImp travelPlanningService;
	
	
	// http://localhost:8089/SpringMVC/retrieve-all-travels

	@GetMapping("/retrieve-all-travels")
	@ResponseBody
	public List<TravelPlanning> getTravels() {
	List<TravelPlanning> listTravels = travelPlanningService.getAllTravelPlanning();
	return listTravels;

	}
	
	// http://localhost:8089/SpringMVC/retrieve-travel/3
	@GetMapping("/retrieve-travel/{travelplanning-Id}")
	@ResponseBody
	public TravelPlanning retrieveTravelPlanning(@PathVariable("travelplanning-Id") Long Id) {
	return travelPlanningService.getTravelPlanningById(Id);
	}
	
	// http://localhost:8089/SpringMVC/retrieve-travel-critere
		@PostMapping("/retrieve-travel-critere")
		@ResponseBody
		public Map<TravelPlanning, Integer> retrieveTravelPlanningByCritere(@RequestBody SearchCritere t) {
			Map<TravelPlanning,Integer> scores=new HashMap<TravelPlanning, Integer>();
			for(TravelPlanning travel : travelPlanningService.getAllTravelPlanning()) {
				int score=0;
				if(travel.getDestination().compareTo(t.getDest())==0) {
					score=score+500;
				}
				int diffDuration=Math.abs(travel.getDuration()-t.getDuration());
				score=score+400 -(400*diffDuration);
				if(travel.getMissionType().compareTo(t.getMission())==0) {
					score=score+200;
				}
			    if(score>=400) {
					scores.put(travel, score);
  	
			    }

			}
		return scores;
		}
	
	 // http://localhost:8089/SpringMVC/add-Travel
	@PostMapping("/add-Travel")
	@ResponseBody
	public TravelPlanning addTravelPlanning(@RequestBody TravelPlanning t)
		{
		travelPlanningService.addTravelPlanning(t);
		return t;
		}	
	
	// http://localhost:8089/SpringMVC/remove-travel/{travel-id}
	@DeleteMapping("/remove-travel/{travel-id}")
	@ResponseBody
	public void removeTravelPlanning(@PathVariable("travel-id") Long Id) {
		travelPlanningService.deleteTravelPlanningById(Id);
	}
	
	// http://localhost:8089/SpringMVC/modify-travel
		@PutMapping("/modify-travel")
		@ResponseBody
		public TravelPlanning modifyTravelPlanning(@RequestBody TravelPlanning t) {

		return travelPlanningService.updateTravelPlanning(t);

		}
		
		
	
		@GetMapping("/articles/export/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	    	System.out.println("Export to Excel ...");
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=articles_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	        List<TravelPlanning> listTravels = travelPlanningService.getAllTravelPlanning();
	        TravelExcel excel = new TravelExcel(listTravels);
	        excel.export(response);    
	    }  
		
		
	
	
}
