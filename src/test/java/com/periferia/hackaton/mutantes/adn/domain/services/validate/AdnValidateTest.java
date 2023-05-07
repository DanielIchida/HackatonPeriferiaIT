package com.periferia.hackaton.mutantes.adn.domain.services.validate;

import com.periferia.hackaton.mutantes.adn.domain.entities.Adn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdnValidateTest {

    String[] chain;
    AdnValidate adnValidate;

    Adn adn;

    @BeforeEach
    void setUp() {
        chain  = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        adn = new Adn();
        adn.setIsMutant(false);
        adn.setDna(chain);
        adnValidate = new AdnValidate(adn);
    }

    @Test
    void isFormatByChainTest() {
        adnValidate.isFormatByChain();
        Assertions.assertEquals(adn.getDna(),chain);
    }

    @Test
    void isStructureDnaTest() {
        adnValidate.isStructureDna();
        Assertions.assertEquals(adn.getDna(),chain);
    }

}
