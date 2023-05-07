package com.periferia.hackaton.mutantes.adn.domain.services;

import com.google.gson.Gson;
import com.periferia.hackaton.mutantes.adn.application.repository.AdnRepository;
import com.periferia.hackaton.mutantes.adn.domain.entities.Adn;
import com.periferia.hackaton.mutantes.adn.domain.events.OnResponseMutantStats;
import com.periferia.hackaton.mutantes.adn.domain.events.OnResponseMutantValidate;
import com.periferia.hackaton.mutantes.adn.domain.services.AdnServices;
import com.periferia.hackaton.mutantes.adn.domain.services.search.SearchMutant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AdnServicesTest {

    @InjectMocks
    AdnServices adnServices;

    @Mock
    AdnRepository repository;

    @Mock
    SearchMutant searchMutant;

    @Mock
    OnResponseMutantStats onResponseMutantStats;

    @Mock
    OnResponseMutantValidate onResponseMutantValidate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveDna() {
        String[] chains = {
                "ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"
        };
        String dna = new Gson().toJson(chains);
        Mockito.doNothing().when(repository).save(dna,true);
        onResponseMutantValidate.onCallback(true);
        Adn adn = new Adn();
        adn.setDna(chains);
        adn.setIsMutant(true);
        adnServices.save(adn,onResponseMutantValidate);
        Mockito.verify(repository).save(dna,true);
        Assertions.assertTrue(adn.getIsMutant());
    }

    @Test
    void statsDna() {
        Mockito.when(repository.countMutants(true)).thenReturn(5);
        Mockito.when(repository.countMutants(false)).thenReturn(5);
        onResponseMutantStats.onCallback(5,5,1);
        adnServices.statistics(onResponseMutantStats);
        Mockito.verify(repository).countMutants(true);
        Assertions.assertEquals(repository.countMutants(true),5);
    }





}
