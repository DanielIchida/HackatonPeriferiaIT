package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionLinear extends SearchPosition{
    public SearchPositionLinear(char[][] dna, int row, int col, char letter, PositionEnum positionEnum) {
        super(dna, row, col, letter, positionEnum);
    }

    @Override
    public int numMatches() {
        int numberOfLetters = 0;
        int chainsNumber = 0;
        if(dna[row][col] == letter) {
            if(positionEnum == PositionEnum.HORIZONTAL) {
                for (int k = col ; k < 4 ; k++) {
                    if(dna[row][k] == letter)
                        numberOfLetters++;
                    else {
                        break;
                    }
                }
            }
            if(positionEnum == PositionEnum.VERTICAL) {
                for (int k = row ; k < 4 ; k++) {
                    if(dna[k][col] == letter)
                        numberOfLetters++;
                    else {
                        break;
                    }
                }
            }
        }
        if(numberOfLetters > 3)
            chainsNumber++;

        return chainsNumber;

    }
}
