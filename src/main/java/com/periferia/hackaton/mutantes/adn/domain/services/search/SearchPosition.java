package com.periferia.hackaton.mutantes.adn.domain.services.search;


public abstract class SearchPosition {

    protected String[] dna;
    protected PositionEnum positionEnum;

    protected int letterCounter = 1;
    protected int mutantCounter = 0;

    protected int midPoint;

    protected SearchPosition(String[] dna, PositionEnum positionEnum) {
        this.dna = dna;
        this.positionEnum = positionEnum;
        this.midPoint = (dna[0].length() / 2);
    }

    public abstract int numMatches();

    protected void validateFourLetters() {
        if(letterCounter == 4) {
            mutantCounter++;
            letterCounter = 0;
        }
    }


}
