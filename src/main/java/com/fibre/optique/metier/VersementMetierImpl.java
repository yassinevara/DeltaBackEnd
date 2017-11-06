package com.fibre.optique.metier;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fibre.optique.dao.VersementRepository;
import com.fibre.optique.entities.Versement;
import com.fibre.optique.service.IndividuRestService;


@Service
public class VersementMetierImpl implements VersementMetier {
	private Logger logger = Logger.getLogger(VersementMetierImpl.class);
	@Autowired
	private  VersementRepository versementRepository;

	@Override
	public Versement saveVersement(Versement vers) {
		DateFormat format  = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();
		String tmp = format.format(date);
		try {
			vers.setDateVersement(format.parse(tmp));
		} catch (ParseException e) {
			logger.info("erreur parsin date");
		}
		return versementRepository.save(vers);
	}

	@Override
	public Versement getVersement(Long id) {
		return versementRepository.findOne(id);
	}

	@Override
	public List<Versement> getAllVersement() {
		return versementRepository.findAll();
	}
	
}
