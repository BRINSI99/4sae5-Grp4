package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.TravelFavoriteServiceImp;

@RestController
public class FavoriteArticle {
	
	@Autowired
	TravelFavoriteServiceImp favoriteService;

	
	
	
	
	
	// http://localhost:8089/SpringMVC/unfavorite-travel/{unfavorite-id}
	@DeleteMapping("/unfavorite-travel/{travel-id}")
	@ResponseBody
	public void unfavoriteTravel(@PathVariable("unfavorite-id") Long Id) {
		favoriteService.removeTravelFavorite(null);
		
	}
	
}
