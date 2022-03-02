package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;

import tn.esprit.spring.service.TwillioService;

@RestController
public class SmsController {

	@Autowired
	TwillioService twillioService;
	

	private String from;
	
	
	private String to;

	
	//http://localhost:8089/SpringMVC/sendSms
	@GetMapping("/sendSms")
	public String sendSms() {
		
		String body = "Hello. Good Morning!!";
		twillioService.sendSms(to, from, body);
		return "message sent successfully";
		
		
	}
	
	
	

	
	@GetMapping("/makeCall")
	public String makeVoiceCall() {
		
		twillioService.makeCall(from, to);
		return "call initiated..";
		
		
	}
}
