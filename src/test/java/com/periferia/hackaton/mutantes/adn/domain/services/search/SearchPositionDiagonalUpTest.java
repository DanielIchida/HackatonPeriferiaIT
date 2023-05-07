package com.periferia.hackaton.mutantes.adn.domain.services.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchPositionDiagonalUpTest {

    String[] chain;
    SearchPositionDiagonalUp searchPositionDiagonalUp;

    @BeforeEach
    void setUp() {
        chain  = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    }


    @Test
    void positionDiagonalUpRight() {
        searchPositionDiagonalUp = new SearchPositionDiagonalUp(chain,PositionEnum.RIGHT);
        Assertions.assertEquals(searchPositionDiagonalUp.numMatches(),0);
    }

    @Test
    void positionDiagonalUpLeft() {
        searchPositionDiagonalUp = new SearchPositionDiagonalUp(chain,PositionEnum.LEFT);
        Assertions.assertEquals(searchPositionDiagonalUp.numMatches(),0);
    }

}
