package tn.spring.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.services.IEncryption;

@RestController
 
public class EncryptionController {
	@Autowired
private IEncryption encryptionsService;

	@GetMapping("/encrypt")
	public String encrypt(@RequestParam String encrypt)
	{
		 
		String resultat=encryptionsService.encrypt(encrypt);
		return resultat ;
		
	}
	@GetMapping("/decrypt")

	public String dencrypt(@RequestParam String decrypt)
	{
		 System.out.print("decrypt :" +encryptionsService.decrypt(decrypt));
		String resultat=encryptionsService.decrypt(decrypt);
		return resultat ;
		
	}
}
