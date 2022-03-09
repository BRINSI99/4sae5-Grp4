package tn.esprit.spring.service;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.Mail;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public String sendEmail(String To, String Subject, String Text) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("hanajenhaani@gmail.com");
		message.setTo("hana.janhani@esprit.tn");
		message.setSubject("Reservation Successfully");
		message.setText("Thank you for trust to TravelTrip  Your reservation has been successfully registered Cordially");
		javaMailSender.send(message);
		
		return "Mail sent successfully";
	}
	
	public String sendEmailwithAttachment(String To, String Subject, String Text)  {

		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			
			MimeMessageHelper messageHelper = 
					new MimeMessageHelper(message, true);
			
			messageHelper.setFrom("hanajenhaani@gmail.com");
			messageHelper.setTo("hana.janhani@esprit.tn");
			messageHelper.setSubject("Reservation Successfully");
			messageHelper.setText("<h1> Reservation Successfully </h1>, <p> Thank you for trust to TravelTrip  Your reservation has been successfully registered <p>  <h2>Cordially</h2>", true);
	
			FileSystemResource file = new FileSystemResource(new File("C:\\Users\\PC\\Desktop\\Stoage\\logo.jpg"));	
			messageHelper.addAttachment("logo.jpg", file);
			
			javaMailSender.send(message);
			
			return "Mail sent successfully";
			
		} catch (Exception e) {
			return "Mail sent failed";
		}
	
	}
}
