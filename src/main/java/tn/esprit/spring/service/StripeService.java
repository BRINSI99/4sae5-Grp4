package tn.esprit.spring.service;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Coupon;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Response;
import tn.esprit.spring.repository.MessageRepository;
import tn.esprit.spring.repository.ResponseRepository;

import javax.lang.model.util.SimpleElementVisitor7;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {
	@Value("${stripe.key.secret}")
	private String API_SECET_KEY;

	@Autowired
	ResponseRepository responseRepository;

	public StripeService() {

	}

	public String createCharge(String email, String token, int amount) {
		
		String chargeId = null;
		
		try {
			Stripe.apiKey = API_SECET_KEY;
			
			Map<String, Object> chargeParams = new HashMap<>();
			chargeParams.put("description","Charge for "+email);


			chargeParams.put("currency","usd");
			chargeParams.put("amount",amount);

			System.out.println(amount);

			chargeParams.put("source",token);

			System.out.println(token);
			Charge charge = Charge.create(chargeParams);

		    chargeId = charge.getId();
			System.out.println(chargeId);

			System.out.println(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargeId;
	}
}
