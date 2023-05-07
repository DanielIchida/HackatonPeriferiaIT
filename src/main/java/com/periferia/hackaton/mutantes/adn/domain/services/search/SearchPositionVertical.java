package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionVertical extends SearchPosition{

    public SearchPositionVertical(String[] dna,
                                  PositionEnum positionEnum) {
        super(dna, positionEnum);
    }

    @Override
    public int numMatches() {
        if(positionEnum == PositionEnum.UP) {
            validatePositionUp();
        }
        if(positionEnum == PositionEnum.DOWN) {
            validatePositionDown();
        }
        return mutantCounter;
    }

    private void validatePositionUp() {
        for (int col = dna.length - 1; col >= midPoint; col--) {
            for (int row = 1; row < dna.length; row++) {
                if (dna[row].charAt(col) == dna[row - 1].charAt(col)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                validateFourLetters();
            }
            letterCounter = 1;
        }
    }

    private void validatePositionDown() {
        for (int col = 0; col < midPoint; col++) {
            for (int row = 1; row < dna.length; row++) {
                if (dna[row].charAt(col) == dna[row - 1].charAt(col)) {
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
