package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.TravelRepository;
import tn.esprit.spring.entity.TravelPlanning;

@Service
@Slf4j
public class TravelPlanningServiceImp implements ITravelPlanningService {
	


@Autowired
TravelRepository travelRepository;

	@Override
	public List<TravelPlanning> getAllTravelPlanning() {
	List<TravelPlanning> TravelPlannings =  travelRepository.findAll();
	return TravelPlannings;
		
	}

	@Override
	public TravelPlanning addTravelPlanning(TravelPlanning t) {
		return travelRepository.save(t);
	}

	@Override
	public TravelPlanning updateTravelPlanning(TravelPlanning t) {
		return travelRepository.save(t);
	}

	@Override
	public TravelPlanning getTravelPlanningById(long Id) {
		return travelRepository.findById(Id).get();
	}

	@Override
	public void deleteTravelPlanningById(long Id) {
		this.travelRepository.deleteById(Id);
		
	}

}
