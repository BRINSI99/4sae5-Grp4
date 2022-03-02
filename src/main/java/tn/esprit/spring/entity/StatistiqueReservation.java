package tn.esprit.spring.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;




public class StatistiqueReservation  {


   
    private String  nom;
    
   
    private int nbplacereservation;


	public StatistiqueReservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public StatistiqueReservation(String nom, int nbplacereservation) {
		super();
		this.nom = nom;
		this.nbplacereservation = nbplacereservation;
	}




	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getNbplacereservation() {
		return nbplacereservation;
	}


	public void setNbplacereservation(int nbplacereservation) {
		this.nbplacereservation = nbplacereservation;
	}




	@Override
	public String toString() {
		return "StatistiqueReservation [nom=" + nom + ", nbplacereservation=" + nbplacereservation + "]";
	}

	
    

}
