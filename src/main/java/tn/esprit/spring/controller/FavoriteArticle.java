package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.TravelFavoriteRepository;
import tn.esprit.spring.entity.TravelFavorite;
import tn.esprit.spring.service.TravelFavoriteServiceImp;

@RestController
public class FavoriteArticle {
	
	@Autowired
	TravelFavoriteServiceImp favoriteService;
	@Autowired
	TravelFavoriteRepository favoriteRepository;
	
	
	
	
	
	// http://localhost:8089/SpringMVC/unfavorite-travel/{unfavorite-id}
	@DeleteMapping("/unfavorite-travel/{unfavorite-id}")
	@ResponseBody
	public void unfavoriteTravel(@PathVariable("unfavorite-id") Long Id) {
		TravelFavorite favorite=favoriteRepository.findById(Id).get();
		favoriteService.removeTravelFavorite(favorite);
		
	}
	//  http://localhost:8089/SpringMVC/add-favorite-travel
	@PostMapping("/add-favorite-travel")
	@ResponseBody
	public TravelFavorite addfavoriteTravel(@RequestBody TravelFavorite t) {
		
		return favoriteService.saveFavorite(t);
	}
	//  http://localhost:8089/SpringMVC/get-favorite-travel/1
	@GetMapping("/get-favorite-travel/{user-id}")
	@ResponseBody
	public List<TravelFavorite> getfavoriteTravel(@PathVariable("user-id") int Id) {
		
		return favoriteService.findByUser((int) Id);
	}
	
}
