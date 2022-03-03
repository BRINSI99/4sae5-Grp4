package tn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.spring.entities.Send;
import tn.spring.services.ISend;

@Controller
public class SendController {
	@Autowired
	private ISend ServiceSend;
	@PostMapping("/SMS")
	public void sms(@RequestBody Send send)
	{
		  ServiceSend.addSms(send);
	}
}
