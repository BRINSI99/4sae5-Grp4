package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.StatistiqueReservation;
import tn.esprit.spring.service.ReservationServiceImp;







@RestController
public class ReservationController {
	
	@Autowired
	ReservationServiceImp reservationService;
	
	// http://localhost:8089/SpringMVC/retrieve-all-reservations

				@GetMapping("/retrieve-all-reservations")
				@ResponseBody
				public List<Reservation> getReservations() {
				List<Reservation> listReservations = reservationService.getAllReservations();
				return listReservations;

				}
				
				// http://localhost:8089/SpringMVC/retrieve-reservation/3
				@GetMapping("/retrieve-reservation/{reservation-Id}")
				@ResponseBody
				public Reservation retrieveReservation(@PathVariable("reservation-Id") Long IdReservation) {
				return reservationService.getReservationById(IdReservation);
				}
				
				 // http://localhost:8089/SpringMVC/add-reservation
				@PostMapping("/add-reservation")
				@ResponseBody
				public Reservation addReservation(@RequestBody Reservation r)
					{
					reservationService.addReservation(r);
					return r;
					}	
			/*	 // http://localhost:8089/SpringMVC/pdf/reservation
				@PostMapping("/pdf/reservation")
				@ResponseBody
				public String getPdfReservation()
					{
					reservationService.pdfCreation();
					return "pdf created successfully";
					}
			*/
				// http://localhost:8089/SpringMVC/remove-reservation/{reservation-id}
				@DeleteMapping("/remove-reservation/{reservation-id}")
				@ResponseBody
				public void removeReservation(@PathVariable("reservation-id") Long IdReservation) {
					reservationService.deleteReservationById(IdReservation);
				}
				
				// http://localhost:8089/SpringMVC/modify-reservation
				@PutMapping("/modify-reservation")
				@ResponseBody
				public Reservation modifyreservation(@RequestBody Reservation r) {
				return reservationService.updateReservation(r);

				}
				// http://localhost:8089/SpringMVC/stat-reservation
				
				@RequestMapping(value = "/stat-reservation", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
			    @ResponseBody
			    public List<StatistiqueReservation> statreservation(){
			        return reservationService.statereservation();
			    }
}
				
				
					


