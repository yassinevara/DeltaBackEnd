package com.fibre.optique.metier;

import com.fibre.optique.dao.ContratRepository;
import com.fibre.optique.entities.Contrat;
import com.fibre.optique.entities.Individu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratMetierImpl implements ContratMetier {

    @Autowired
    ContratRepository  contratRepository;

    @Override
    public Contrat saveContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratOfIndividu(Long id) {

        Individu ind = new Individu();
        ind.setIdIndividu(id);
        return contratRepository.findContratByIndividu(ind);
    }

    @Override
    public Contrat getContrat(Long id) {
        return contratRepository.findOne(id);
    }

    @Override
    public Boolean deleteContrat(Long id) {
        contratRepository.delete(id);
        return true;
    }
}
