package tn.esprit.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.EmailService;

@RestController
@RequestMapping("/api")
public class EmailController {
	

	@Autowired
	EmailService emailService;
	
	//http://localhost:8089/SpringMVC/api/sendEmail

	@GetMapping("/sendEmail")
	public String sendEmail() {
		return emailService.sendEmail(null, null, null);
	}
	
	@GetMapping("/sendEmailwithAttachment")
	public String sendEmailwithAttachment() {
		return emailService.sendEmailwithAttachment(null, null, null);
	}
	

}
