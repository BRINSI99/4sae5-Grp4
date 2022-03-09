package tn.esprit.spring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.TravelFavorite;


public interface TravelFavoriteRepository extends JpaRepository<TravelFavorite, Long> {
	
	   

}
