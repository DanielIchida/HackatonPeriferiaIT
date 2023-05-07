package com.periferia.hackaton.mutantes.adn.application.usescases;


import com.periferia.hackaton.mutantes.adn.domain.entities.Adn;
import com.periferia.hackaton.mutantes.adn.domain.events.OnResponseMutantValidate;
import com.periferia.hackaton.mutantes.adn.domain.services.AdnServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SaveAdnTest {

    @InjectMocks
    private SaveAdn saveAdn;

    @Mock
    private AdnServices adnServices;

    String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateSave() {
        Adn adn = new Adn();
        adn.setDna(dna);
        adn.setIsMutant(false);
        OnResponseMutantValidate onResponseMutantValidate = adn::setIsMutant;
        adnServices.save(adn,onResponseMutantValidate);
        saveAdn.execute(dna);
        boolean validate = saveAdn.isValidateMutant();
        Assertions.assertFalse(validate);
    }

}
