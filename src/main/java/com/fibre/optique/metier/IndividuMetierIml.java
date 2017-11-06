package com.fibre.optique.metier;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fibre.optique.dao.IndividuRepository;
import com.fibre.optique.entities.Individu;

@Service
public class IndividuMetierIml implements IndividuMetier {

	@Autowired
	IndividuRepository individuRepository;
	@Override
	public Individu saveIndividu(Individu ind) {
		
		return individuRepository.save(ind);
	}

	@Override
	public List<Individu> getIndividuByName(String name) {
		if(name.equals(null)||name.equals("")){
			return this.getAllIndividu();
		}
		return individuRepository.findByNomIgnoreCaseContaining(name) ;
	}

	@Override
	public Individu getIndividuByNumSec(String numSec) {
		Individu ind = individuRepository.findTop1ByNumSecurite(numSec);
		if(ind ==null) throw new RuntimeException("Individu Innexistant");
		return ind;
		
		
	}


	@Override
	public List<Individu> getAllIndividu() {
		
		return individuRepository.findAll();
	}

	@Override
	public Individu getIndividu(Long id) {
		
		return individuRepository.findOne(id);
	}

	@Override
	public Boolean deleteIndividu(Long id) {
		individuRepository.delete(id);
		return true;
	}

	@Override
	public Page<Individu> searchByName(String nom, int page, int size) {
		
		return individuRepository.searchByName(nom, new PageRequest(page, size));
	}

}
