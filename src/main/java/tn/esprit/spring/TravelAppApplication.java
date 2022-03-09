package tn.esprit.spring;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import tn.esprit.spring.service.EmailService;



@SpringBootApplication
public class TravelAppApplication {
	@Autowired
	private EmailService service;

	public static void main(String[] args) {
		
		SpringApplication.run(TravelAppApplication.class, args);
	}
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() {
		service.sendEmailwithAttachment("hana.janhani@esprit.tn", "Successfully Reservation ", "<h1> Reservation Successfully </h1>, <p> Thank you for trust to TravelTrip  Your reservation has been successfully registered <p>  <h2>Cordially</h2> ,\"C:\\Users\\PC\\Desktop\\Stoage\\logo.jpg\"");
	}
	
	
	
	

}
