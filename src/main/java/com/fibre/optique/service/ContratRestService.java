package com.fibre.optique.service;

import com.fibre.optique.entities.Contrat;
import com.fibre.optique.entities.Individu;
import com.fibre.optique.entities.Versement;
import com.fibre.optique.metier.ContratMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ContratRestService {

    @Autowired
    ContratMetier contratMetier;

    @RequestMapping(value="/contrats",method= RequestMethod.POST) //
    public Contrat save(@RequestBody Contrat c) {

        return contratMetier.saveContrat(c);
    }

    @RequestMapping(value="/contrats",method=RequestMethod.GET)
    public List<Contrat> listContrat() {
        return contratMetier.getAllContrat();
    }

    @RequestMapping(value="/contrats/individus/{id}",method=RequestMethod.GET)
    public Contrat getContratOfIndividu(@PathVariable Long id) {
        return contratMetier.getContratOfIndividu(id);
    }

}
