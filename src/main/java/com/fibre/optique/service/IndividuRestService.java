package com.fibre.optique.service;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.fibre.optique.entities.Individu;
import com.fibre.optique.metier.IndividuMetier;


@RestController
@CrossOrigin
public class IndividuRestService {

	@Autowired
	private IndividuMetier individuMetier;
	private Logger logger = Logger.getLogger(IndividuRestService.class);
	
	@RequestMapping(value="/individus",method=RequestMethod.POST) //
	public Individu save( @RequestBody   Individu ind) {
		logger.info("individ");
		logger.info("individu enregistré :"+ ind);
		return individuMetier.saveIndividu(ind);
	}
	
	@RequestMapping(value="/individus",method=RequestMethod.GET) 
	public List<Individu> listIndividu() {
		return individuMetier.getAllIndividu();
	}
	
	@RequestMapping(value="/individus/{id}",method=RequestMethod.GET) //
	public Individu getIndividu(@PathVariable Long id) {
		return individuMetier.getIndividu(id);
	}
	
	@RequestMapping(value="/individus/{id}",method=RequestMethod.DELETE) //supprression
	public Boolean supprimerIndividu(@PathVariable Long id) {
		return individuMetier.deleteIndividu(id);
	}
	
	@RequestMapping(value="/individus/{id}",method=RequestMethod.PUT) //mise a jour
	public Individu updateIndividu(@PathVariable Long id,@RequestBody Individu ind) {
		ind.setIdIndividu(id);
		return individuMetier.saveIndividu(ind);
	}
	
	@RequestMapping(value="/searchIndividus",method=RequestMethod.GET) 
	public Page<Individu> searchIndividuByName(
			@RequestParam(name="nom",defaultValue="") String nom,
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return individuMetier.searchByName("%"+nom+"%", page, size);
	}
	
	@RequestMapping(value="/individusByName",method=RequestMethod.GET)
	public List<Individu> getIndividuByName(@RequestParam(name="nom",defaultValue="") String nom){
		logger.info("get individu by name"+nom);
		return individuMetier.getIndividuByName(nom);
	}
	
	@RequestMapping(value="/individusByNumSec/{numSec}",method=RequestMethod.GET) 
	public Individu getIndividuByNumSec(@PathVariable String numSec){
		
		return individuMetier.getIndividuByNumSec(numSec);
	}
	
}
