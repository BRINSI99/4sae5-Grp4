package tn.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.lowagie.text.DocumentException;

import tn.spring.entities.FeedBack;
import tn.spring.entities.Reclamations;
import tn.spring.entities.User;
import tn.spring.services.FeedBackService;
import tn.spring.services.IEncryption;
import tn.spring.services.UserPDFExporter;

 



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
	 

	@PostMapping("/addFeedBack/{id}")
	@ResponseBody
	
	public void ajouterEtAffecterClientBoutiques(@RequestBody FeedBack f, @PathVariable("id") long id) {
		
		cs.CompanyAddToFeedBack(f, id);
		 
		
		
	}
	/**exporter fichier pdf avec id comapnies*/
	   @GetMapping("/exportPDF/{id}")
	   public void exportToPDF(HttpServletResponse response, @PathVariable("id") long id) throws DocumentException, IOException {
	       response.setContentType("application/pdf");
	       DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	       String currentDateTime = dateFormatter.format(new Date());
	        
	       String headerKey = "Content-Disposition";
	       String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	       response.setHeader(headerKey, headerValue);
	        
	       List<FeedBack> dataList= cs.findByCompanies(id);
		
	        
	       UserPDFExporter exporter = new UserPDFExporter(dataList);
	       exporter.export(response);
	        
	   }
	

	
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
  	
  	

	@PutMapping("/modifyFeedBack/{id}")
	@ResponseBody
	public FeedBack ModifyFeedBack(@PathVariable("id") Integer idClaim,@RequestBody FeedBack t) {
	return cs.updateClaimById(t, idClaim);
	}
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
