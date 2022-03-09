package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.TravelFavoriteRepository;
import tn.esprit.spring.entity.TravelFavorite;

@Service
public class TravelFavoriteServiceImp implements ITravelFavorite{
	

  @Autowired
  TravelFavoriteRepository travelFavoriteRepository;
	
	
	@Override
	public TravelFavorite saveFavorite(TravelFavorite travelFavorite) {
		
		return travelFavoriteRepository.save(travelFavorite);
	}

	

	@Override
	public void removeTravelFavorite(TravelFavorite favorite) {
		travelFavoriteRepository.delete(favorite);
		
	}



	@Override
	public List<TravelFavorite> findByUser(int user_id) {
		// TODO Auto-generated method stub
		return travelFavoriteRepository.findAll().stream().filter(x->x.getId()==(long)user_id).toList();
	}

}
