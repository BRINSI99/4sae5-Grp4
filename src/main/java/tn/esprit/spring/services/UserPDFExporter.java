package tn.spring.services;


import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import tn.spring.entities.FeedBack;
import tn.spring.entities.User;
import tn.spring.repository.UserRepository;
 
 
public class UserPDFExporter {
  
	private List<FeedBack> listFeedBack;
    @Autowired
     private UserRepository repo;
    public UserPDFExporter(List<FeedBack> listFeedBack2) {
        this.listFeedBack = listFeedBack2;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("FeedBack ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Content", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date-FeedBack", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Companies-ID", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date ", font));
        table.addCell( cell);       
    }
     
    private void writeTableData(PdfPTable table  ) {
    	  
        for (FeedBack user : listFeedBack) {
        	Days DateTime;
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getContent());
            table.addCell(String.valueOf(user.getDateFeedBack()));
            table.addCell(String.valueOf(user.getCompanies().getId()));
            table.addCell(String.valueOf(java.time.LocalDate.MIN.now()));        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(8);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}