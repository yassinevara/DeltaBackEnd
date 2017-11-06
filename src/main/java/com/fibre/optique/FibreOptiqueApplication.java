package com.fibre.optique;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fibre.optique.dao.IndividuRepository;
import com.fibre.optique.entities.Individu;
import com.fibre.optique.entities.Versement;
import com.fibre.optique.metier.IndividuMetier;
import com.fibre.optique.metier.VersementMetier;
import com.fibre.optique.service.IndividuRestService;

@SpringBootApplication
public class FibreOptiqueApplication implements CommandLineRunner {
	
	private Logger logger = Logger.getLogger(FibreOptiqueApplication.class);
	
	@Autowired
	private VersementMetier versementMetier;
	@Autowired
	private IndividuMetier individuMetier;

	public static void main(String[] args) {
		SpringApplication.run(FibreOptiqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		DateFormat format  = new SimpleDateFormat("yyyy/mm/dd");
		//individuRepository.save(new Individu("asri", "mohamed", "122111"));
		//individuRepository.save(new Individu("asri", "toto", "122111"));
		//individuRepository.save(new Individu("klasri", "mohamed", "122111", null));
		/*
		 * save versement
		 */
		Individu ind = new Individu();
		ind.setIdIndividu(1L);
		Date date = new Date();
		String tmp = format.format(date);
		//versementMetier.saveVersement(new Versement(7000, format.parse(tmp), ind));
		//Individu indi = individuRepository.getOne(1L);
		//Versement vers =versementMetier.getVersement(1L) ;
		String nom  = "as";
		//logger.info("name "+("%"+nom+"%"));
		logger.info("indiv by name"+individuMetier.getIndividuByName(nom).get(0).getPrenom());
	}
}
