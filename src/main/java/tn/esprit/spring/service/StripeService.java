package tn.esprit.spring.service;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Response;
import tn.esprit.spring.repository.ResponseRepository;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {
    @Value("${stripe.key.secret}")
    private String API_SECET_KEY;

    @Autowired
    ResponseRepository responseRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String createCharge(String email, String token, int amount) {

        String chargeId = null;

        try {
            Stripe.apiKey = API_SECET_KEY;
            Map<String, Object> chargeParams = new HashMap<>();
            Response r = new Response();
            chargeParams.put("description", "Charge for " + email);
            r.setEmail(email);
            ;
            chargeParams.put("currency", "usd");
            chargeParams.put("amount", amount);
            r.setAmount(amount);
            System.out.println(amount);

            chargeParams.put("source", token);
            r.setToken(token);

            System.out.println(token);
            Charge charge = Charge.create(chargeParams);

            chargeId = charge.getId();
            System.out.println(chargeId);
            System.out.println(email);
            responseRepository.save(r);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return chargeId;
    }

}
