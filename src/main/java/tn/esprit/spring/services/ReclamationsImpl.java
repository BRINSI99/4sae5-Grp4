package tn.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Reclamations;
import tn.spring.entities.Status;
import tn.spring.repository.ReclamationsRepository;



 

 

@Service

public class ReclamationsImpl implements ReclamationsService {
	@Autowired
	ReclamationsRepository repository;

	@Override
	public Reclamations addClaim(Reclamations c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public List<Reclamations> retrieveAllClaim() {
		// TODO Auto-generated method stub
		return (List<Reclamations>) repository.findAll();
	}

	@Override
	public void deleteClaim(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public Reclamations updateClaim(Reclamations c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public Reclamations updateClaimById(Reclamations o, Integer idClaim) {
		// TODO Auto-generated method stub

		Reclamations cl= repository.findById(idClaim).orElse(null);
		
		cl.setContent(o.getContent());
		cl.setStatus(o.getStatus());
		cl.setStatus(o.getStatus());
		//cl.setId(o.getId());

cl.setDateComplaint(o.getDateComplaint());

 
//cl.setUser(o.getUser());
repository.saveAndFlush(cl);


repository.saveAndFlush(cl);
return cl;
	}

	

 

	 

	@Override
	public Status convertToEntityAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reclamations> getAllReclamations(Long idUser) {
		// TODO Auto-generated method stub
		  return repository.findMealByStatus2(idUser);
	}

	@Override
	public List<Reclamations> getAllReclamationss(Long idUser) {
		// TODO Auto-generated method stub
		return repository.findMealByStatus1(idUser);
	}

	@Override
	public List<Reclamations> getAllReclamationsss(Long idUser) {
		// TODO Auto-generated method stub
		return repository.findMealByStatus0(idUser);
	}
	 
	

	
	
	
	

	
	
}