package com.fibre.optique.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.fibre.optique.entities.Individu;

public interface IndividuMetier {

	public Individu saveIndividu (Individu ind);
	public List<Individu> getIndividuByName (String name);
	public Individu getIndividuByNumSec (String numSec);
	public List<Individu> getAllIndividu();
	public Individu getIndividu(Long id);
	public Boolean deleteIndividu(Long id);
	public Page<Individu> searchByName (String nom,int page, int size);
}
