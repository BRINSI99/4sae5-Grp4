package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
	
	
}
