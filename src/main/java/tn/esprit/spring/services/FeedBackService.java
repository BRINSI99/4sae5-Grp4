package tn.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tn.spring.entities.FeedBack;



public interface FeedBackService {
	public FeedBack CompanyAddToFeedBack(FeedBack c,long id);
	 
	 
		List<FeedBack> retrieveAllClaim();
		void deleteClaim(long id);
		FeedBack updateClaim(FeedBack c);

		FeedBack updateClaimById(FeedBack o, long idClaim);
		public	String encrypt(String data);
	     
	    public	String decrypt(String data);


	     
	 
}
