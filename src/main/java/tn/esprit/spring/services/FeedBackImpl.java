	package tn.spring.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Company;
import tn.spring.entities.FeedBack;
import tn.spring.entities.Reclamations;
import tn.spring.repository.CompanyRepository;
import tn.spring.repository.FeedBackRepository;
import tn.spring.services.EncryptionImpl.AES;



 

 

@Service
public class FeedBackImpl implements FeedBackService {
	@Autowired
	FeedBackRepository repository;
	@Autowired
	CompanyRepository comrep;
	private static final String AES_KEY="TOKEN_KEY";
	
	AES aes=new AES(AES_KEY);
	@Override
	public FeedBack CompanyAddToFeedBack(FeedBack c,long id) {
 		Company com = comrep.findById(id).get();
	        c.setCompanies(com);
	     
	       c.setContent(aes.encrypt(c.getContent()));
	        
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
	
	
	

	
	
}