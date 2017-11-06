package com.fibre.optique.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("LO")
public class Logement  extends Mission {

	
	
	private int quantite;
	private double prixUnite;
	
	
	public Logement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Logement(int quantite, double prixUnite) {
		super();
		this.quantite = quantite;
		this.prixUnite = prixUnite;
	}


	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrixUnite() {
		return prixUnite;
	}
	public void setPrixUnite(double prixUnite) {
		this.prixUnite = prixUnite;
	}

	
}
