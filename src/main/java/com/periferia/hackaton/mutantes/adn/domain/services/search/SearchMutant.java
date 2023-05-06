package com.periferia.hackaton.mutantes.adn.domain.services.search;

import com.periferia.hackaton.mutantes.adn.domain.util.ConvertArray;
import java.util.concurrent.*;

public class SearchMutant {
    private final char[] letters = {'T','C','G','A'};

    public boolean validateIsMutant(String[] dna){
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Future<Boolean> callableResult = executorService.submit(processIsMutant(dna));
        try {
            return callableResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Callable<Boolean> processIsMutant(String[] dna) {
        return () -> {
            int sumMatches = 0;
            char[][] newDna = new ConvertArray().charTwoDimensions(dna);
            for(char letter : letters) {
                for(int row = 0 ; row < newDna.length ; row++) {
                    for(int col = 0 ; col < newDna.length ; col++) {
                          sumMatches = sumMatches + new SearchPositionLinear(newDna,row,col,letter,PositionEnum.HORIZONTAL).numMatches();
                          sumMatches = sumMatches + new SearchPositionLinear(newDna,row,col,letter,PositionEnum.VERTICAL).numMatches();
                          sumMatches = sumMatches + new SearchPositionObliqueTop(newDna,row,col,letter, PositionEnum.LEFT).numMatches();
                          sumMatches = sumMatches + new SearchPositionObliqueTop(newDna,row,((dna.length - 1) - col),letter,PositionEnum.RIGHT).numMatches();
                          sumMatches = sumMatches + new SearchPositionObliqueBottom(newDna,((dna.length - 1) - row),col,letter,PositionEnum.LEFT).numMatches();
                          sumMatches = sumMatches + new SearchPositionObliqueBottom(newDna,((dna.length - 1) - row),((dna.length - 1) - col),letter,PositionEnum.RIGHT).numMatches();
                    }
                }
            }
            return sumMatches > 1;
        };
    }
}
