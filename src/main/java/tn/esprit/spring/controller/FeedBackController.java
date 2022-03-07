package tn.spring.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 
import tn.spring.entities.FeedBack;
<<<<<<<<< Temporary merge branch 1
 import tn.spring.services.FeedBackService;
=========
import tn.spring.entities.Reclamations;
import tn.spring.services.FeedBackService;
>>>>>>>>> Temporary merge branch 2
import tn.spring.services.IEncryption;

 



@RestController
 
public class FeedBackController {
	@Autowired
	FeedBackService cs;

	
	
	
	
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<FeedBack> getAllClaim()
	{
		List<FeedBack> listClaim = cs.retrieveAllClaim();
		return listClaim; 	
	}
	 
<<<<<<<<< Temporary merge branch 1
	
	
	
	
	
=========

>>>>>>>>> Temporary merge branch 2
	@PostMapping("/addFeedBack/{id}")
	@ResponseBody
	
	public void ajouterEtAffecterClientBoutiques(@RequestBody FeedBack f, @PathVariable("id") long id) {
		
		cs.CompanyAddToFeedBack(f, id);
		 
		
		
	}
	
	
<<<<<<<<< Temporary merge branch 1
 
	
	
=========

>>>>>>>>> Temporary merge branch 2
	
	@PutMapping("/modify")
	@ResponseBody
	public FeedBack modifyClient(@RequestBody FeedBack c)
	{
		  return cs.updateClaim(c);
	}
	
	@DeleteMapping("/remove/{id}")
	@ResponseBody
	public void removefeed(@PathVariable("id") long id) {
		cs.deleteClaim(id);
	}
  	
  	

<<<<<<<<< Temporary merge branch 1
=========
	@PutMapping("/modifyFeedBack/{id}")
	@ResponseBody
	public FeedBack ModifyFeedBack(@PathVariable("id") Integer idClaim,@RequestBody FeedBack t) {
	return cs.updateClaimById(t, idClaim);
	}
>>>>>>>>> Temporary merge branch 2
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}