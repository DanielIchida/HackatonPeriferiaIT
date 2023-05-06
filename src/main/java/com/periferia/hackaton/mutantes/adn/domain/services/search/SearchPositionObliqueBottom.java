package com.periferia.hackaton.mutantes.adn.domain.services.search;

public class SearchPositionObliqueBottom extends SearchPosition{
    public SearchPositionObliqueBottom(char[][] dna, int row, int col, char letter, PositionEnum positionEnum) {
        super(dna, row, col, letter, positionEnum);
    }

    @Override
    public int numMatches() {
        int numberOfLetters = 0;
        int chainsNumber = 0;
        int numberPosicionValidate = 4;
        boolean posValidateLeft = true;
        if(positionEnum == PositionEnum.RIGHT){
            numberPosicionValidate = 5;
            posValidateLeft = false;
        }
        if(dna[row][col] == letter) {
            if(row < 0){
                return 0;
            }
            for(int k = col; k < numberPosicionValidate ; k++){
                int size = dna.length - 1;
                if(posValidateLeft){
                    if(row < 0 || row > size){
                        break;
                    }
                }else{
                    if(row < 0){
                        break;
                    }
                }
                if(dna[row][k] == letter){
                    if(posValidateLeft){
                        col = col - 1;
                        row = row + 1;
                    }else{
                        col = col + 1;
                        row = row - 1;
                    }
                    numberOfLetters =  numberOfLetters + 1;
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
