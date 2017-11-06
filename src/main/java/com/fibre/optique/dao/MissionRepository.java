package com.fibre.optique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fibre.optique.entities.Individu;
import com.fibre.optique.entities.Mission;

public interface MissionRepository  extends JpaRepository<Mission, Long>{

}
