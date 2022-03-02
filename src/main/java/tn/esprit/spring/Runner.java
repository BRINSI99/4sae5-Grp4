package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import tn.esprit.spring.service.ReservationServiceImp;

public class Runner implements ApplicationRunner {
	
	
	private ReservationServiceImp  reservationServiceImp ;

	@Autowired
	public Runner(ReservationServiceImp  reservationServiceImp) {
		
		this.reservationServiceImp = reservationServiceImp;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("Application Started to Run");
		reservationServiceImp.pdfCreation();
		System.out.println("Pdf File Got Created");
		
	}

}
