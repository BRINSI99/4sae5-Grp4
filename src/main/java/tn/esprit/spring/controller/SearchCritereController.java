package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.SearchCritere;
import tn.esprit.spring.service.SearchCritereServiceImpl;

@RestController
@RequestMapping("/search")
public class SearchCritereController {
     
	@Autowired
	SearchCritereServiceImpl searchCritereServiceImpl;
	
	
	// http://localhost:8089/SpringMVC/retrieve-SearchCritere/3
	@GetMapping("/retrieve-SearchCritere/{SearchCritere-Id}")
	@ResponseBody
	public SearchCritere retrieveSearchCritere(@PathVariable("id") int id) {
	return searchCritereServiceImpl.getScoreCritereById(id);
	}
	
	 // http://localhost:8089/SpringMVC/add-critere
	@PostMapping("/add-critere")
	@ResponseBody
	public SearchCritere add(@RequestBody SearchCritere s)
		{
		searchCritereServiceImpl.add(s);
		return s;
		}	
	

	// http://localhost:8089/SpringMVC/remove-critere/{critere-id}
	@DeleteMapping("/remove/{id}")
	@ResponseBody
	public void removeReservation(@PathVariable("id") int id) {
		searchCritereServiceImpl.delete(id);
	}
	
	// http://localhost:8089/SpringMVC/modify-critere
	@PutMapping("/modify-critere/{id}")
	@ResponseBody
	public SearchCritere modifyreservation(@RequestBody SearchCritere s,@PathVariable("id") int id) {
	return searchCritereServiceImpl.update(s, id);
	}
	
}
