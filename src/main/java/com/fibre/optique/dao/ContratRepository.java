package com.fibre.optique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fibre.optique.entities.Contrat;

public interface  ContratRepository extends JpaRepository<Contrat, Long>{

}
