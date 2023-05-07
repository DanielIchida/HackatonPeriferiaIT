package com.periferia.hackaton.mutantes.adn.domain.services.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchPositionDiagonalDownTest {

    String[] chain;
    SearchPositionDiagonalDown searchPositionDiagonalDown;

    @BeforeEach
    void setUp() {
        chain  = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    }


    @Test
    void positionDiagonalDownRight() {
        searchPositionDiagonalDown = new SearchPositionDiagonalDown(chain,PositionEnum.RIGHT);
        Assertions.assertEquals(searchPositionDiagonalDown.numMatches(),0);
    }

    @Test
    void positionDiagonalDownLeft() {
        searchPositionDiagonalDown = new SearchPositionDiagonalDown(chain,PositionEnum.LEFT);
        Assertions.assertEquals(searchPositionDiagonalDown.numMatches(),1);
    }

}
