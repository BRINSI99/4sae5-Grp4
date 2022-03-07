package tn.spring.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tn.spring.entities.Company;
import tn.spring.entities.FeedBack;



public interface FeedBackService {
	public FeedBack CompanyAddToFeedBack(FeedBack c,long id);
	 
	 
		List<FeedBack> retrieveAllClaim();
		void deleteClaim(long id);
		FeedBack updateClaim(FeedBack c);

		FeedBack updateClaimById(FeedBack o, long idClaim);
		public	String encrypt(String data);
	     
	    public	String decrypt(String data);
	    List<FeedBack> findByCompanies(Long companies_id );

	    public void advancedSearch() ;
	    List<FeedBack> findFeedBackByIdOrContent(String content,Company companies );

	   
	 


 
	     
	 
}
