package com.periferia.hackaton.mutantes.adn.domain.services.search;

import com.periferia.hackaton.mutantes.adn.domain.entities.Adn;
import com.periferia.hackaton.mutantes.adn.domain.services.validate.AdnValidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchMutantTest {

    String[] chain;

    SearchMutant searchMutant;

    @BeforeEach
    void setUp() {
        chain  = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        searchMutant = new SearchMutant();
    }

    @Test
    void testIsMutant() {
        Assertions.assertTrue(searchMutant.validateIsMutant(chain));
    }

    @Test
    void testIsNotMutant() {
        chain = new String[]{"AGAGAG", "AACTCG", "TCTGTA", "TGAATA", "CGGTCC", "ACAGTC"};
        Assertions.assertFalse(searchMutant.validateIsMutant(chain));
    }

}
