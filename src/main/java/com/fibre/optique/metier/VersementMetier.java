package com.fibre.optique.metier;

import java.util.List;


import com.fibre.optique.entities.Versement;

public interface VersementMetier {
	public Versement saveVersement(Versement vers);
	public Versement getVersement(Long id);
	public List<Versement> getAllVersement();
}
