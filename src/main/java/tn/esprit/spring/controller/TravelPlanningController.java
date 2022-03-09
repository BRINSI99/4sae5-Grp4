package tn.esprit.spring.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.entity.Critere;
import tn.esprit.spring.entity.SearchCritere;

import tn.esprit.spring.entity.TravelPlanning;
import tn.esprit.spring.service.SearchCritereServiceImpl;
import tn.esprit.spring.service.TravelPlanningServiceImp;

@RestController
public class TravelPlanningController {
	
	@Autowired
	TravelPlanningServiceImp travelPlanningService;
	
	@Autowired	
	SearchCritereServiceImpl searchCritereServiceImpl;
	
	@Autowired  ServletContext context;
	
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
		public Map<TravelPlanning, Integer> retrieveTravelPlanningByCritere(@RequestBody Critere t) {
			Map<TravelPlanning,Integer> scores=new HashMap<TravelPlanning, Integer>();
			SearchCritere destination=searchCritereServiceImpl.getScoreCritereById(1);
			SearchCritere duration=searchCritereServiceImpl.getScoreCritereById(2);
			SearchCritere durrationDiff=searchCritereServiceImpl.getScoreCritereById(3);
			SearchCritere mission=searchCritereServiceImpl.getScoreCritereById(4);
			SearchCritere like=searchCritereServiceImpl.getScoreCritereById(5);
			SearchCritere share=searchCritereServiceImpl.getScoreCritereById(6);
			SearchCritere valid=searchCritereServiceImpl.getScoreCritereById(7);
			for(TravelPlanning travel : travelPlanningService.getAllTravelPlanning()) {
				int score=0;
				
				if(travel.getDestination().compareTo(destination.getName())==0) {
					score=score+destination.getScore();
				}
				int diffDuration=Math.abs(travel.getDuration()-t.getDuration());
				score=score+duration.getScore() -(durrationDiff.getScore()*diffDuration);
				if(travel.getMissionType().compareTo(t.getMission())==0) {
					score=score+mission.getScore();
				}
				score=score+like.getScore()*travel.getLikes();
				score=score+share.getScore()*travel.getShare();
			    if(score>=valid.getScore()) {
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
		
	
	
}
