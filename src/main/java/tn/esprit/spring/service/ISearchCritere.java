package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.SearchCritere;

public interface ISearchCritere {

	SearchCritere getScoreCritereById(int id);
	int getScoreCritereByName(String name);
	boolean add(SearchCritere s);
	SearchCritere update(SearchCritere s,int id);
	boolean delete(int id);
    List<SearchCritere> getAll();
	
}
