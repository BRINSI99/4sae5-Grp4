package tn.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.spring.entities.Send;
import tn.spring.entities.SmsPojo;
 


@Component
	public class SmsService {
	 
 
	    
	    private final String ACCOUNT_SID ="ACc833a6a29e863acbba4a339fb74f5b5c";

	    private final String AUTH_TOKEN = "8d33316a69a9b90c8d05befe99a49ec0";

	    private final String FROM_NUMBER = "+18607914156";

	    public void send(SmsPojo sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }
	   

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}
