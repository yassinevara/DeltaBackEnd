package com.fibre.optique.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fibre.optique.entities.Individu;

public interface IndividuRepository  extends JpaRepository<Individu, Long> {

	
	Individu findTop1ByNumSecurite(String numSec);
	
	List<Individu> findByNom(String nom);
	List<Individu> findByNomIgnoreCaseContaining(String nom) ;
	@Query ("select i from Individu i where i.nom like :n")
	public Page<Individu> searchByName (@Param("n") String nom,Pageable pageable);
}
