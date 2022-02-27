package tn.esprit.spring;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TravelAppApplication {

	@PostConstruct
	public void setup()
	{
		Stripe.apiKey = "pk_test_51KX1K0E0eqielpuruy9lPD5F6fKFhdjJzjXYQBVQcQ0G6PHS0McLq4R0oXlOGl7Q92uz03GCuS6Y9AvMyHg9FQ96008kqDGUrM";
	}
	public static void main(String[] args) {
		SpringApplication.run(TravelAppApplication.class, args);
	}

}
