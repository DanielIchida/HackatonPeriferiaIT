package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionHorizontal extends SearchPosition{

    public SearchPositionHorizontal(String[] dna,
                                    PositionEnum positionEnum) {
        super(dna, positionEnum);
    }

    @Override
    public int numMatches() {
        int letterCounter = 1;
        int mutantCounter = 0;
        int midPoint = (dna[0].length() / 2);
        if(positionEnum == PositionEnum.LEFT) {
            for (int row = dna.length - 1; row >= midPoint; row--) {
                for (int col = 1; col < dna.length; col++) {
                    if (dna[row].charAt(col) == dna[row].charAt(col - 1)) {
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
        if(positionEnum == PositionEnum.RIGHT) {
            for (int row = 0; row < midPoint; row++) {
                for (int col = 1; col < dna.length; col++) {
                    if (dna[row].charAt(col) == dna[row].charAt(col - 1)) {
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
