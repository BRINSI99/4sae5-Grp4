package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.esprit.spring.entity.TravelFavorite;

public interface ITravelFavorite {
	
	 TravelFavorite saveFavorite(TravelFavorite travelFavorite);
	
	 List <TravelFavorite>find(String TravelId, String user_id);

	 void removeTravelFavorite(TravelFavorite favorite);

}
