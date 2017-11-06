package com.fibre.optique.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "versement")
public class Versement  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVersement ;
	
	private double salaire;
	@Temporal(TemporalType.DATE)
	private Date dateVersement;
	
	@ManyToOne 
	@JoinColumn(name="INDIVIDU_ID")//cle etranger
	private Individu individu;
	public Versement() {
		super();
		
	}
	/**
	 * @param salaire
	 * @param dateVersement
	 * @param individu
	 */
	public Versement(double salaire, Date dateVersement, Individu individu) {
		super();
		this.salaire = salaire;
		this.dateVersement = dateVersement;
		this.individu = individu;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public Date getDateVersement() {
		return dateVersement;
	}
	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}
	public Individu getIndividu() {
		return individu;
	}
	public void setIndividu(Individu individu) {
		this.individu = individu;
	}
	public Long getIdVersement() {
		return idVersement;
	}

	
	

}
