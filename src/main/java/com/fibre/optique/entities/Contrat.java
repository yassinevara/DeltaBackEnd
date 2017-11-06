package com.fibre.optique.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "contrat")
public class Contrat implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContrat ;
	@Temporal(TemporalType.DATE)
	private Date dateEntree;
	@Temporal(TemporalType.DATE)
	private Date dateSortie;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Individu individu;

	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contrat(Date dateEntree, Date dateSortie, Individu individu) {
		super();
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.individu = individu;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Individu getIndividu() {
		return individu;
	}

	public void setIndividu(Individu individu) {
		this.individu = individu;
	}

	public Long getIdContrat() {
		return idContrat;
	}
	
}
