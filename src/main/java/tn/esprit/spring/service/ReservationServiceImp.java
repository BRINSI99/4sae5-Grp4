package tn.esprit.spring.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.ReservationRepository;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.StatistiqueReservation;




@Service
@Slf4j
public class ReservationServiceImp implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	



	@Override
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
		return reservations;
	}



	@Override
	public Reservation addReservation(Reservation R) {
		
		return reservationRepository.save(R);
	}



	@Override
	public Reservation updateReservation(Reservation R) {
	
		return reservationRepository.save(R);
	}



	@Override
	public Reservation getReservationById(long IdReservation) {
		return reservationRepository.findById(IdReservation).get();
	}



	@Override
	public void deleteReservationById(long IdReservation) {
		this.reservationRepository.deleteById(IdReservation);
		
	}
	
	public void pdfCreation()
	{
		String filepath="C:\\Users\\PC\\Desktop\\PdfFiles\\SimplePdf.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			
			PdfDocument pdfdoc=new PdfDocument(writer);
			pdfdoc.addNewPage();
			
			Document document=new Document(pdfdoc);
			document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}



	@Override
	public List<StatistiqueReservation> statereservation() {
		  List<StatistiqueReservation> stats=new ArrayList<>();
	        List <Reservation> reservations=(List<Reservation>) reservationRepository.findAll();
	        for(Reservation r:reservations)
	        {
	        	StatistiqueReservation stat =new StatistiqueReservation();
	        	String fullName=r.getUsers().getFirstname()+" "+r.getUsers().getLastname();
	        	if(stats.stream().anyMatch(x->x.getNom().compareTo(fullName)==0)) {
	        		stats.stream().filter(x->x.getNom()==fullName).forEach(x->x.setNbplacereservation(x.getNbplacereservation()+r.getTravels().getReservations().size()));
	        	}
	        	else {
	        		  stat.setNom(fullName);
	  	            stat.setNbplacereservation(r.getTravels().getReservations().size());
	  	            stats.add(stat);
	        	}
	          ;
	        }
		return stats;
	}
	

	   
}

