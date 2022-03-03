package tn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.entities.Categorie;
import tn.spring.entities.Statistique;
import tn.spring.services.StatistiqueService;
 
 

@RestController
public class StatistiqueController {

	@Autowired
	StatistiqueService clientService;

	@PutMapping("/statistique/{id}")
	public  Statistique ADDSta(@RequestBody Statistique c, @PathVariable("id") int id) {
		return clientService.ADDSta(c, id);
	}
	/*
	@GetMapping("/list-client/{idBoutique}")
	@ResponseBody
	List<Client> listedeClients(@PathVariable("idBoutique") Long idBoutique){
		return clientService.listedeClients(idBoutique);
	}
	
	@GetMapping("/liste-clientParCategorie/{categorie}")
	List<Client> listeDeClientsParCategorie(@PathVariable("categorie") Categorie categorie){
		return clientService.listeDeClientsParCategorie(categorie);
	}
	*/
}
