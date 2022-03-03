package tn.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.spring.entities.Reclamations;
import tn.spring.entities.Status;


@Service

public interface ReclamationsService {
	Reclamations addClaim( Reclamations c);
	 
	 
		List<Reclamations> retrieveAllClaim();
		void deleteClaim(Integer id);
	Reclamations updateClaim(Reclamations c);

	Reclamations updateClaimById(Reclamations o, Integer idClaim);
	
	
	
	
	List<Reclamations> getAllReclamations();
	List<Reclamations> getAllReclamationss();
	List<Reclamations> getAllReclamationsss();


	Status convertToEntityAttribute();
	
	 
}
