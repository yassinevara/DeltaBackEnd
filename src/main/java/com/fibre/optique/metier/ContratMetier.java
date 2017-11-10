package com.fibre.optique.metier;

import com.fibre.optique.entities.Contrat;
import com.fibre.optique.entities.Individu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContratMetier {


    public Contrat saveContrat (Contrat c);
    public List<Contrat> getAllContrat ();
    public Contrat getContratOfIndividu(Long idIndividu);
    public Contrat getContrat(Long id);
    public Boolean deleteContrat(Long id);

}
