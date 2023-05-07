package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionVertical extends SearchPosition{

    public SearchPositionVertical(String[] dna,
                                  PositionEnum positionEnum) {
        super(dna, positionEnum);
    }

    @Override
    public int numMatches() {
        int letterCounter = 1;
        int mutantCounter = 0;
        int midPoint = (dna[0].length() / 2);
        if(positionEnum == PositionEnum.UP) {
            for (int col = dna.length - 1; col >= midPoint; col--) {
                for (int row = 1; row < dna.length; row++) {
                    if (dna[row].charAt(col) == dna[row - 1].charAt(col)) {
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
        if(positionEnum == PositionEnum.DOWN) {
            for (int col = 0; col < midPoint; col++) {
                for (int row = 1; row < dna.length; row++) {
                    if (dna[row].charAt(col) == dna[row - 1].charAt(col)) {
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
