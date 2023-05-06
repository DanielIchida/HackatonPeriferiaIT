package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionObliqueTop extends SearchPosition{
    public SearchPositionObliqueTop(char[][] dna, int row, int col, char letter, PositionEnum positionEnum) {
        super(dna, row, col, letter, positionEnum);
    }

    @Override
    public int numMatches() {
        int numberOfLetters = 0;
        int chainsNumber = 0;
        int numberPosicionValidate = 4;
        if (positionEnum == PositionEnum.RIGHT) {
            numberPosicionValidate = 5;
        }

        if(dna[row][col] == letter) {
            int size = dna.length - 1;
            if(row == size){
                return 0;
            }
            for(int k = col; k < numberPosicionValidate ; k++){
                if(row > size){
                    break;
                }
                if(dna[row][k] == letter){
                    row = row + 1;
                    numberOfLetters++;
                }else{
                    break;
                }
            }
        }

        if(numberOfLetters > 3)
            chainsNumber++;

        return chainsNumber;
    }
}
