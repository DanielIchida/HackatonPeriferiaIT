package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionHorizontal extends SearchPosition{

    public SearchPositionHorizontal(String[] dna,
                                    PositionEnum positionEnum) {
        super(dna, positionEnum);
    }

    @Override
    public int numMatches() {
        if(positionEnum == PositionEnum.LEFT) {
            validatePositionLeft();
        }
        if(positionEnum == PositionEnum.RIGHT) {
            validatePositionRight();
        }
        return mutantCounter;
    }

    private void validatePositionLeft() {
        for (int row = dna.length - 1; row >= midPoint; row--) {
            for (int col = 1; col < dna.length; col++) {
                if (dna[row].charAt(col) == dna[row].charAt(col - 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                validateFourLetters();
            }
            letterCounter = 1;
        }
    }

    private void validatePositionRight() {
        for (int row = 0; row < midPoint; row++) {
            for (int col = 1; col < dna.length; col++) {
                if (dna[row].charAt(col) == dna[row].charAt(col - 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                validateFourLetters();
            }
            letterCounter = 1;
        }
    }
}
