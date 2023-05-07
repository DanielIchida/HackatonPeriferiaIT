package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionDiagonalUp extends SearchPosition{
    public SearchPositionDiagonalUp(String[] dna, PositionEnum positionEnum) {
        super(dna, positionEnum);
    }

    @Override
    public int numMatches() {
        if(positionEnum == PositionEnum.RIGHT) {
            validatePositionRightUp();
        }
        if(positionEnum == PositionEnum.LEFT) {
            this.validatePositionLeftUp();
        }
        return mutantCounter;
    }

    private void validatePositionLeftUp() {
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

    private void validatePositionRightUp() {
        for (int rowPivot = 3; rowPivot < dna.length -1; rowPivot++) {
            for (int row = rowPivot, col = dna.length - 1; row > 0; row--, col--) {
                if (dna[row].charAt(col) == dna[row - 1].charAt(col - 1)) {
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
