package tn.esprit.spring.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.ReservationRepository;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.StatistiqueReservation;
import com.itextpdf.text.Image;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;



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

        try {
            // creation of the document with a certain size and certain margins
            Document document = new Document(PageSize.A4, 20, 20, 20, 20);

                // write the all into a file and save it.
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\PC\\Desktop\\PdfFiles\\Reservation.pdf"));

            document.open();
            //Title
            Image image = Image.getInstance("C:\\Users\\PC\\Desktop\\Stoage\\logo.jpg");
            image.scaleToFit(90, 90);
            //Add content to the document using Image object.
            document.add(image);
            Paragraph title = new Paragraph("Resevation succes");
            Date date = new Date(System.currentTimeMillis());
            Paragraph d = new Paragraph(date.toString());
            title.setAlignment(Element.ALIGN_CENTER);
            d.setAlignment(Element.ALIGN_CENTER);
    
            Paragraph contact = new Paragraph("Merci, votre réservation a été effectuée avec succès!  ");
            contact.setAlignment(Element.ALIGN_CENTER);
            //Generating QrCode
            BarcodeQRCode barcodeQRCode = new BarcodeQRCode("Hana@gmail.com", 1000, 1000, null);
            Image codeQrImage = barcodeQRCode.getImage();
            codeQrImage.scaleAbsolute(300, 300);
            codeQrImage.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
           
            document.add(d);
         
            document.add(contact);
            document.add(codeQrImage);
            document.close();

            System.out.println("Pdf Generated successfully.");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


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
	
	/*public void pdfCreation()
	{
		String filepath="C:\\Users\\PC\\Desktop\\PdfFiles\\SimplePdf.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			
			PdfDocument pdfdoc=new PdfDocument(writer);
			pdfdoc.addNewPage();
			Paragraph title = new Paragraph("");
			Document document=new Document(pdfdoc);
			document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

*/

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

