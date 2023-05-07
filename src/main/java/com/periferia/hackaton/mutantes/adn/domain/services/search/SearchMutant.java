package com.periferia.hackaton.mutantes.adn.domain.services.search;

import java.util.concurrent.*;

public class SearchMutant {

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
            sumMatches = sumMatches + new SearchPositionHorizontal(dna,PositionEnum.LEFT).numMatches();
            sumMatches = sumMatches + new SearchPositionHorizontal(dna,PositionEnum.RIGHT).numMatches();
            sumMatches = sumMatches + new SearchPositionVertical(dna,PositionEnum.UP).numMatches();
            sumMatches = sumMatches + new SearchPositionVertical(dna,PositionEnum.DOWN).numMatches();
            sumMatches = sumMatches + new SearchPositionDiagonalUp(dna,PositionEnum.LEFT).numMatches();
            sumMatches = sumMatches + new SearchPositionDiagonalUp(dna,PositionEnum.RIGHT).numMatches();
            sumMatches = sumMatches + new SearchPositionDiagonalDown(dna,PositionEnum.LEFT).numMatches();
            sumMatches = sumMatches + new SearchPositionDiagonalDown(dna,PositionEnum.RIGHT).numMatches();
            return sumMatches > 0;
        };
    }
}
