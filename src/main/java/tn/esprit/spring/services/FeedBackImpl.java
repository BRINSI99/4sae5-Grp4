	package tn.spring.services;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

 

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 

 
import tn.spring.entities.Company;
import tn.spring.entities.Employee;
import tn.spring.entities.FeedBack;
import tn.spring.entities.Reclamations;
import tn.spring.repository.CompanyRepository;
import tn.spring.repository.EmployeeRepository;
import tn.spring.repository.FeedBackRepository;
 



 

 

@Service
public class FeedBackImpl implements FeedBackService {

	@Autowired
	FeedBackRepository repository;
	@Autowired
	CompanyRepository comrep;
	@Autowired
	EmployeeRepository exampleRepo ;
	private static final String AES_KEY="TOKEN_KEY";
	
	AES aes=new AES(AES_KEY);
	 @Autowired
	    private JavaMailSender javaMailSender;
	    
	@Override
	public FeedBack CompanyAddToFeedBack(FeedBack c,long id) {
 		Company com = comrep.findById(id).get();
	        c.setCompanies(com);
	     
	      // c.setContent(aes.decrypt(c.getContent()));
	       
	       MimeMessage mimeMessage = javaMailSender.createMimeMessage();
           MimeMessageHelper helper =
            new MimeMessageHelper(mimeMessage, "utf-8");
           try {
			helper.setFrom("walid.gammoudi@esprit.tn");
			helper.setTo("aicha.nouisser@esprit.tn");
           helper.setSubject("FeedBack");
           helper.setText(c.getContent());
           javaMailSender.send(mimeMessage);
           
           
           
           
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
		return repository.save(c);
	}
	 

	@Override
	public List<FeedBack> retrieveAllClaim() {
		// TODO Auto-generated method stub
		return (List<FeedBack>) repository.findAll();
	}

	  

	@Override
	public FeedBack updateClaim(FeedBack c) {
		// TODO Auto-generated method stub
		 
		return repository.save(c);
	}

	@Override
	public void deleteClaim(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	 
	 


	@Override
	public FeedBack updateClaimById(FeedBack o, long idClaim) {
		FeedBack cl= repository.findById(idClaim).orElse(null);
		
		cl.setContent(o.getContent());
		cl.setDateFeedBack(o.getDateFeedBack());
		cl.setCompanies(o.getCompanies());
 


 
 repository.saveAndFlush(cl);


 return cl;
	}


	@Override
	public String encrypt(String data) {
		// TODO Auto-generated method stub
		AES aes=new AES(AES_KEY);
		
		return aes.encrypt(data);
		 
	}







	@Override
	public String decrypt(String data) {
		// TODO Auto-generated method stub
		AES aes=new AES(AES_KEY);
		return aes.decrypt(data);
	}

 

 
	
	

	 public class AES 
	 {
		 private SecretKeySpec secretkey;
		 private byte[] key;
		 AES(String  secret)
		 {
			 MessageDigest sha=null;
			 try {
				 key=secret.getBytes(StandardCharsets.ISO_8859_1);
				 
				sha=MessageDigest.getInstance("SHA-1");
				key=sha.digest(key);
				key=Arrays.copyOf(key, 16);
				secretkey=new SecretKeySpec(key,"AES");
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 String encrypt(String strToEncrypt){
			 try {
				Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
				
				 cipher.init(Cipher.ENCRYPT_MODE, secretkey);
					return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.ISO_8859_1)));
				   
		 
		 
	 
		 
			 }	
			 catch(Exception e)
			 {
				 
			 }
			return null;
	

		 }
		 String decrypt(String strToDecrypt)
		 {
			 try{
				 Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
				 cipher.init(Cipher.DECRYPT_MODE, secretkey);
					return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
				   
		 
			 }
			 catch (Exception e ){
				 
			 }
			return null;
		 }
		 }







	@Override
	public List<FeedBack> findByCompanies( Long a) {
	 
	List<FeedBack> feed =repository.findByCompanies( a);
		 

		
		return feed;
	}

	 	 
	 public void advancedSearch()  {
	        FeedBack feed = new FeedBack();
	        
	        
	            feed.setContent("hello");
	        
	        

	        Example<FeedBack> example = Example.of(feed, ExampleMatcher.matchingAny());
	               

	        

 
	        Iterable<FeedBack> employees = repository.findAll(example);
	        for (FeedBack e : employees) {
	            System.out.println(e);
	        }
	     	 
	    	   

	       

	       
	       

	        
	    }
	
	 public List<FeedBack> findFeedBackByIdOrContent(String content,Company companies ) {
		 
 	        FeedBack employee = new FeedBack();
	        employee.setContent(content);
	        employee.setCompanies(companies);
	    
	         
	       
	        
	        
	        
	        ExampleMatcher employeeExample = ExampleMatcher.matching()
	                .withMatcher("content", contains().ignoreCase())
	                .withMatcher("companies", contains().ignoreCase());
	                
	        Example<FeedBack> example = Example.of(employee, employeeExample);
	        Iterable<FeedBack> employees = repository.findAll(example);

	        for (FeedBack e : employees) {
	            System.out.println(e.getCompanies());
	        }
			return repository.findAll(example);
	    }
	
 
	


}
