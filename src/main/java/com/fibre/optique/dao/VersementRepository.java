package com.fibre.optique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fibre.optique.entities.Versement;

public interface VersementRepository extends JpaRepository<Versement, Long>{

}
