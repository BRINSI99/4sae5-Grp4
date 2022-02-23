package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Company;

public interface ICompanyService {
	
	Company addCompany(Company c);
	
	List<Company> ShowAllUniOff();
	
	int DeleteCompany(int X);
	
	Company ModifyCompany(Company c,int x);

}
