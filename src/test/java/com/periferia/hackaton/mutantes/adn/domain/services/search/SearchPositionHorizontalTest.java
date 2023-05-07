package com.periferia.hackaton.mutantes.adn.domain.services.search;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchPositionHorizontalTest {

    String[] chain;
    SearchPositionHorizontal searchPositionHorizontal;

    @BeforeEach
    void setUp() {
        chain  = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    }

    @Test
    void testPositionHorizontalLeft() {
        searchPositionHorizontal = new SearchPositionHorizontal(chain,PositionEnum.LEFT);
        Assertions.assertEquals(searchPositionHorizontal.numMatches(),1);
    }

    @Test
    void testPositionHorizontalRight() {
        searchPositionHorizontal = new SearchPositionHorizontal(chain,PositionEnum.RIGHT);
        Assertions.assertEquals(searchPositionHorizontal.numMatches(),0);
    }

}
