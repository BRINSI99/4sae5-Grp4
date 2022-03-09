package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.SearchCritereRepository;
import tn.esprit.spring.entity.SearchCritere;

@Service
public class SearchCritereServiceImpl implements ISearchCritere {
	
	@Autowired
	SearchCritereRepository searchCritereRepository;

	@Override
	public SearchCritere getScoreCritereById(int id) {
		// TODO Auto-generated method stub
		return searchCritereRepository.getById((long)id);
	}

	@Override
	public int getScoreCritereByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(SearchCritere s) {
		searchCritereRepository.save(s);
		return true;
	}

	@Override
	public SearchCritere update(SearchCritere s, int id) {
		SearchCritere sMod=searchCritereRepository.getById((long)id);
		sMod.setName(s.getName());
		sMod.setScore(s.getScore());
		searchCritereRepository.save(sMod);
		return sMod;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(searchCritereRepository.findById((long)id).isPresent()) {
			searchCritereRepository.deleteById((long) id);
return true;
		}
		return false;
	}

	@Override
	public List<SearchCritere> getAll() {
		// TODO Auto-generated method stub
		return searchCritereRepository.findAll();
	}

}
