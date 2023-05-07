package com.periferia.hackaton.mutantes.adn.domain.services;

import com.google.gson.Gson;
import com.periferia.hackaton.mutantes.adn.application.repository.AdnRepository;
import com.periferia.hackaton.mutantes.adn.domain.entities.Adn;
import com.periferia.hackaton.mutantes.adn.domain.events.OnResponseMutantStats;
import com.periferia.hackaton.mutantes.adn.domain.events.OnResponseMutantValidate;
import com.periferia.hackaton.mutantes.adn.domain.services.search.SearchMutant;
import com.periferia.hackaton.mutantes.adn.domain.services.validate.AdnValidate;

public class AdnServices {

    private final AdnRepository repository;
    private final SearchMutant searchMutant;

    public AdnServices(AdnRepository adnRepository) {
        this.repository = adnRepository;
        searchMutant = new SearchMutant();
    }

    public void save(Adn adn, OnResponseMutantValidate response) {
        AdnValidate adnValidate = new AdnValidate(adn);
        adnValidate.isStructureDna();
        adnValidate.isFormatByChain();
        boolean isMutant = searchMutant.validateIsMutant(adn.getDna());
        adn.setIsMutant(isMutant);
        String dna = new Gson().toJson(adn.getDna());
        if(!repository.exist(dna)) repository.save(dna,isMutant);
        response.onCallback(isMutant);
    }

    public void statistics(OnResponseMutantStats onResponseMutantStats) {
        float ratio;
        int mutants = repository.countMutants(true);
        int humans = repository.countMutants(false);
        ratio = mutants != 0 ? ((float) mutants / humans) : 0;
        onResponseMutantStats.onCallback(humans,mutants,ratio);
    }






}
