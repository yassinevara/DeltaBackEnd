package com.fibre.optique.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "individu")
public class Individu  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idIndividu ;
	private String nom;
	private String prenom;
	private String numSecurite;
	@OneToOne (mappedBy="individu")
	private Contrat contrat;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="individu") //biderctionnel charger les versements en cas de besoin
	private Collection <Versement> versements; 
	@ManyToMany
	private Set <Mission> missions ;
	
	public Individu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Individu(String nom, String prenom, String numSecurite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numSecurite = numSecurite;
	
	}


	public Long getIdIndividu() {
		return idIndividu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumSecurite() {
		return numSecurite;
	}
	public void setNumSecurite(String numSecurite) {
		this.numSecurite = numSecurite;
	}

	@JsonIgnore
	public Collection<Versement> getVersements() {
		return versements;
	}


	public void setVersements(Collection<Versement> versements) {
		this.versements = versements;
	}


	public void setIdIndividu(Long idIndividu) {
		this.idIndividu = idIndividu;
	}
	
	
	
	
}
