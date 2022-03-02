package tn.esprit.spring.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Response;
import tn.esprit.spring.repository.ResponseRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class StripeService {
    @Value("${stripe.key.secret}")
    private String API_SECET_KEY;

    @Autowired
    ResponseRepository responseRepository;

    @Autowired
    private JavaMailSender mailSender;

    public String createCharge(String email, String token, int amount) {

        String chargeId = null;

        try {
            Stripe.apiKey = API_SECET_KEY;
            Map<String, Object> chargeParams = new HashMap<>();
            Response r = new Response();
            chargeParams.put("description", "Charge for " + email);
            r.setEmail(email);

            chargeParams.put("currency", "usd");
            chargeParams.put("amount", amount);

            r.setAmount(amount);
            System.out.println(amount);

            chargeParams.put("source", token);
            r.setToken(token);
            System.out.println(token);

            Charge charge = Charge.create(chargeParams);
            chargeId = charge.getId();
            System.out.println(chargeId);

            responseRepository.save(r);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Mailing API
        String from = "benhassinenassim98@gmail.com";
        String to = email;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Payment Successful !");
        message.setText("Dear Mr/Ms ," + email + " you Payed " + amount / 100.0 + "$");
        mailSender.send(message);
        //end Mailing API

        try {
            // creation of the document with a certain size and certain margins
            Document document = new Document(PageSize.A4, 20, 20, 20, 20);

            // creating table and set the column width
            PdfPTable table = new PdfPTable(2);
            float widths[] = {3, 6};
            table.setWidths(widths);
            table.setHeaderRows(1);

            // add cell of table - header cell
            PdfPCell cell = new PdfPCell(new Phrase("Email"));
            cell.setBackgroundColor(new BaseColor(250, 253, 250));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Amount"));
            cell.setBackgroundColor(new BaseColor(250, 253, 250));
            table.addCell(cell);
            Phrase ph;

            cell = new PdfPCell();
            ph = new Phrase(email);
            cell.addElement(ph);
            table.addCell(cell);

            cell = new PdfPCell();
            ph = new Phrase(amount + " $");
            cell.addElement(ph);
            table.addCell(cell);

            // write the all into a file and save it.
            PdfWriter.getInstance(document, new FileOutputStream("E:\\invoice.pdf"));

            document.open();
            //Title
            Paragraph title = new Paragraph("Payment receipt");
            title.setAlignment(Element.ALIGN_CENTER);
            Chunk linebreak = new Chunk(new DottedLineSeparator());
            document.add(title);
            document.add(linebreak);
            document.add(table);

            document.close();
            System.out.println("Pdf Generated successfully.");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chargeId;
    }

}
