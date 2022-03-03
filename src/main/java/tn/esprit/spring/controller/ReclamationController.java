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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.spring.entities.Employee;
import tn.spring.entities.Reclamations;
import tn.spring.entities.Send;
import tn.spring.entities.Statistique;
import tn.spring.entities.Status;
import tn.spring.services.ISend;
import tn.spring.services.ReclamationsService;

 

@Controller
public class ReclamationController {
	
	 
	@Autowired
	private ReclamationsService cs;
 
	  
	

	
	
	
	
	@GetMapping("/get-all-Claim")
	@ResponseBody
	public List<Reclamations> getAllClaim()
	{
		List<Reclamations> listClaim = cs.retrieveAllClaim();
		return listClaim; 	
	}
	
	
	
	
	
	
	@PostMapping("/addClaim")
	@ResponseBody
	public Reclamations addClaim(@RequestBody Reclamations c)
	{
		return cs.addClaim(c);
	}
	
	
	
	
	
	
	
	
	@PutMapping("/modify-Claim")
	@ResponseBody
	public Reclamations modifyClient(@RequestBody Reclamations c)
	{
		return cs.updateClaim(c);
	}
	
	@DeleteMapping("/remove-Claim/{idClaim}")
	@ResponseBody
	public void removeClaim(@PathVariable("idClaim") Integer idClaim) {
		cs.deleteClaim(idClaim);
	}
  	
  	

	
	@PutMapping("/modify-Claim-byID/{id}")
	@ResponseBody
	public Reclamations ModifyClaim(@PathVariable("id") Integer idClaim,@RequestBody Reclamations t) {
	return cs.updateClaimById(t, idClaim);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/stat")
	public String getAllEmployee(Model model) {	
		
		  
		List<Reclamations> dataList = cs.getAllReclamations();
		List<Reclamations> dataList1 = cs.getAllReclamationss();
		List<Reclamations> dataList0= cs.getAllReclamationsss();
		int s=0;
		 int m=0;
     	int y=0;
	 List<Integer> list1 = null;
	 List<Integer> list2 = null;
	 List<Integer> list0 = null;
	 
	for(Reclamations data : dataList) {
		 
		 
		m++;
		 
	}
	for(Reclamations data : dataList1) {
		 
		
		 
			 s++;
			
		 
	}
	for(Reclamations data : dataList0) {
		 
		
		 
		 y++;
		
	 
		 
}
	 
  
 	  
	list1 = Arrays.asList(y).stream().collect(Collectors.toList());
	list1.add(s);
 	list1.add(m);
	   
	 
	model.addAttribute("age", list1);
	 
 	 
 	model.addAttribute("total", s+m+y);
 	
 	
	return "barChart";
	
	}
}
