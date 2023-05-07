package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionDiagonalUp extends SearchPosition{
    public SearchPositionDiagonalUp(String[] dna, PositionEnum positionEnum) {
        super(dna, positionEnum);
    }

    @Override
    public int numMatches() {
        int letterCounter = 1;
        int mutantCounter = 0;
        if(positionEnum == PositionEnum.RIGHT) {
            for (int rowPivot = 3; rowPivot < dna.length -1; rowPivot++) {
                for (int row = rowPivot, col = dna.length - 1; row > 0; row--, col--) {
                    if (dna[row].charAt(col) == dna[row - 1].charAt(col - 1)) {
                        letterCounter++;
                    } else {
                        letterCounter = 1;
                    }
                    if(letterCounter == 4) {
                        mutantCounter++;
                        letterCounter = 0;
                    }
                }
                letterCounter = 1;
            }
        }
        if(positionEnum == PositionEnum.LEFT) {
            for (int rowPivot = dna.length - 4; rowPivot >= 0; rowPivot--) {
                for (int row = rowPivot, col = dna.length - 1; dna.length - row > 1; row++, col--) {
                    if (dna[row].charAt(col) == dna[row + 1].charAt(col - 1)) {
                        letterCounter++;
                    } else {
                        letterCounter = 1;
                    }
                    if(letterCounter == 4) {
                        mutantCounter++;
                        letterCounter = 0;
                    }
                }
                letterCounter = 1;
            }
        }
        return mutantCounter;
    }
}
