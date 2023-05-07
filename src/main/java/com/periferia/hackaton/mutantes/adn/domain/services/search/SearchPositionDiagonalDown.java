package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionDiagonalDown extends SearchPosition{
    public SearchPositionDiagonalDown(String[] dna, PositionEnum positionEnum) {
        super(dna,positionEnum);
    }

    @Override
    public int numMatches() {
        if(positionEnum == PositionEnum.RIGHT) {
            validatePositionRightDown();
        }
        if(positionEnum == PositionEnum.LEFT) {
            this.validatePositionLeftDown();
        }
        return mutantCounter;
    }

    private void validatePositionRightDown() {
        for (int rowPivot = dna.length - 4; rowPivot >= 0; rowPivot--) {
            for (int row = rowPivot, col = dna.length - 1; dna.length - row > 1; row++, col--) {
                if (dna[row].charAt(col) == dna[row + 1].charAt(col - 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                validateFourLetters();
            }
            letterCounter = 1;
        }
    }

    private void validatePositionLeftDown() {
        for (int rowPivot = dna.length - 4; rowPivot >= 0; rowPivot--) {
            for (int row = rowPivot, col = 0; dna.length - row > 1; row++, col++) {
                if (dna[row].charAt(col) == dna[row + 1].charAt(col + 1)) {
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
