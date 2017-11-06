package com.fibre.optique.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fibre.optique.entities.Individu;
import com.fibre.optique.entities.Versement;
import com.fibre.optique.metier.VersementMetier;

@RestController
@CrossOrigin
public class VersementRestService {

	@Autowired
	private VersementMetier versementMetier;
	
	private Logger logger = Logger.getLogger(VersementRestService.class);
	
	@RequestMapping(value="/versements",method=RequestMethod.POST) 
	public Versement saveVersement( @RequestBody   Versement ver) {
		logger.info("versement enregistré :"+ ver);
		return versementMetier.saveVersement(ver);
	}
	
	@RequestMapping(value="/versements/{id}",method=RequestMethod.GET) 
	public Versement getVersement(@PathVariable Long id) {
		return versementMetier.getVersement(id);
	}
	
	@RequestMapping(value="/versements",method=RequestMethod.GET) 
	public List<Versement> listIndividu() {
		return versementMetier.getAllVersement();
	}
	
}
