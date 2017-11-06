package com.fibre.optique.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
//pour faire le mapping objet xml
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_MISSION",discriminatorType=DiscriminatorType.STRING,length=2) // Creer dans la table pour differentier les compte

//mapping objet json
//lorsque une donné json a un champs type , il va  savoir que c est une classe derivé
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="LO" ,value=Logement.class),
	@Type(name="AR" ,value=Article.class)
})
public abstract class Mission implements Serializable  {

	@Id
	@Column(name="MISS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMiss ;
	private String adresse;
	private Date dateFinMission;
	@ManyToMany
	private Set <Individu> individus;
	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mission(String adresse, Date dateFinMission, Set<Individu> individus) {
		super();
		this.adresse = adresse;
		this.dateFinMission = dateFinMission;
		this.individus = individus;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateFinMission() {
		return dateFinMission;
	}
	public void setDateFinMission(Date dateFinMission) {
		this.dateFinMission = dateFinMission;
	}
	public Set<Individu> getIndividus() {
		return individus;
	}
	public void setIndividus(Set<Individu> individus) {
		this.individus = individus;
	}
	public Long getIdMiss() {
		return idMiss;
	} 
	
}
