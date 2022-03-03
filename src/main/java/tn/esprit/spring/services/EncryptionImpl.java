package tn.spring.services;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Company;
import tn.spring.entities.FeedBack;
import tn.spring.entities.Send;
import tn.spring.repository.CompanyRepository;
import tn.spring.repository.FeedBackRepository;
import tn.spring.repository.SendRepository;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;



 

 

@Service
public class EncryptionImpl implements IEncryption {
	 private static final String AES_KEY="TOKEN_KEY";
	 


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