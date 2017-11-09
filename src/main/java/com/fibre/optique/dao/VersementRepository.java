package com.fibre.optique.dao;

import com.fibre.optique.entities.Individu;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fibre.optique.entities.Versement;

import java.util.List;

public interface VersementRepository extends JpaRepository<Versement, Long>{

    List<Versement> findDistinctByIndividuOrderByDateVersementDesc(Individu ind);
}
