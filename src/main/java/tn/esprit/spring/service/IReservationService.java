package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.StatistiqueReservation;




public interface IReservationService {
	
    List < Reservation > getAllReservations();
    
	Reservation addReservation(Reservation R);
	
	Reservation updateReservation(Reservation R);
	 
	Reservation getReservationById(long IdReservation);
	
    void deleteReservationById(long IdReservation);
    
    public List<StatistiqueReservation> statereservation();

}
