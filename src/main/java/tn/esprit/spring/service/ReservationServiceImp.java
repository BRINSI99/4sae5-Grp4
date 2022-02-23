package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.ReservationRepository;
import tn.esprit.spring.entity.Reservation;



@Service
@Slf4j
public class ReservationServiceImp implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	



	@Override
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
		return reservations;
	}



	@Override
	public Reservation addReservation(Reservation R) {
		
		return reservationRepository.save(R);
	}



	@Override
	public Reservation updateReservation(Reservation R) {
	
		return reservationRepository.save(R);
	}



	@Override
	public Reservation getReservationById(long IdReservation) {
		return reservationRepository.findById(IdReservation).get();
	}



	@Override
	public void deleteReservationById(long IdReservation) {
		this.reservationRepository.deleteById(IdReservation);
		
	}

	

}
