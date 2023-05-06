package com.periferia.hackaton.mutantes.adn.domain.services.search;

import lombok.Getter;

public abstract class SearchPosition {

    protected char[][] dna;
    protected int row;
    protected int col;
    protected char letter;
    protected PositionEnum positionEnum;

    public SearchPosition(char[][] dna, int row, int col, char letter, PositionEnum positionEnum) {
        this.dna = dna;
        this.row = row;
        this.col = col;
        this.letter = letter;
        this.positionEnum = positionEnum;
    }

    public abstract int numMatches();

}
