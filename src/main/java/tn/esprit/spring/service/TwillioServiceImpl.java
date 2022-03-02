package tn.esprit.spring.service;
import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwillioServiceImpl implements TwillioService {
	private final String ACCOUNT_SID ="AC1272336dfaf920cf19319a0b06280b7f";

    private final String AUTH_TOKEN = "043f16a4bb78aae55f3b1e424d03d651";

    private final String FROM_NUMBER = "+21690153896";
	
	
	

	@Override
	public void sendSms(String to, String from, String body) {
		try {
			 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		        Message message = Message.creator( new PhoneNumber(to), new PhoneNumber(from),body) // to:to which no  you want to send sms           
		            .setMediaUrl(Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))     // from: twillio given phone no
		            .setStatusCallback(URI.create("http://postb.in/1234abcd"))                      // body : text message
		            .create();

		        System.out.println(message);
		        System.out.println(message.getSid());

			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
		
	}

	@Override
	public void makeCall(String from, String to) {
		
		try {
			 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		        Call call = Call.creator(
		                new PhoneNumber(to),
		                new PhoneNumber(from),
		                URI.create("http://demo.twilio.com/docs/voice.xml"))
		            .setStatusCallback(URI.create("http://postb.in/1234abcd"))
		            .create();
		        System.out.println(call);
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
		}
		
		
		
	

	

}