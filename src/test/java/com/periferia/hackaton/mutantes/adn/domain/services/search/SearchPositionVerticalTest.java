package com.periferia.hackaton.mutantes.adn.domain.services.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchPositionVerticalTest {

    String[] chain;
    SearchPositionVertical searchPositionVertical;

    @BeforeEach
    void setUp() {
        chain  = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    }

    @Test
    void testPositionVerticalUp() {
        searchPositionVertical = new SearchPositionVertical(chain,PositionEnum.UP);
        Assertions.assertEquals(searchPositionVertical.numMatches(),1);
    }

    @Test
    void testPositionVerticalDown() {
        searchPositionVertical = new SearchPositionVertical(chain,PositionEnum.DOWN);
        Assertions.assertEquals(searchPositionVertical.numMatches(),0);
    }

}
