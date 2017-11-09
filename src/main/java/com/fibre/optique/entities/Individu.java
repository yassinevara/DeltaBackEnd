package com.fibre.optique.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

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
	// orphanRemoval delete cascade
	@OneToMany(fetch=FetchType.LAZY, mappedBy="individu",orphanRemoval = true) //biderctionnel charger les versements en cas de besoin
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
