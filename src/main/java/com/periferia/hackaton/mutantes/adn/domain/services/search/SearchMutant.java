package com.periferia.hackaton.mutantes.adn.domain.services.search;

import java.util.concurrent.*;

public class SearchMutant {

    public boolean validateIsMutant(String[] dna){
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        int sumMatches = 0;
        try {
            sumMatches = sumMatches + resultNumValidate(executorService,new SearchPositionHorizontal(dna,PositionEnum.LEFT));
            sumMatches = sumMatches + resultNumValidate(executorService,new SearchPositionHorizontal(dna,PositionEnum.RIGHT));
            sumMatches = sumMatches + resultNumValidate(executorService,new SearchPositionVertical(dna,PositionEnum.UP));
            sumMatches = sumMatches + resultNumValidate(executorService,new SearchPositionVertical(dna,PositionEnum.DOWN));
            sumMatches = sumMatches + resultNumValidate(executorService,new SearchPositionDiagonalUp(dna,PositionEnum.LEFT));
            sumMatches = sumMatches + resultNumValidate(executorService,new SearchPositionDiagonalUp(dna,PositionEnum.RIGHT));
            sumMatches = sumMatches + resultNumValidate(executorService,new SearchPositionDiagonalDown(dna,PositionEnum.LEFT));
            sumMatches = sumMatches + resultNumValidate(executorService,new SearchPositionDiagonalDown(dna,PositionEnum.RIGHT));
            return sumMatches > 1;
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    private Callable<Integer> processNumValidate(SearchPosition searchPosition) {
        return searchPosition::numMatches;
    }

    private int resultNumValidate(ExecutorService executorService,SearchPosition searchPosition) throws ExecutionException, InterruptedException {
        return executorService.submit(processNumValidate(searchPosition)).get();
    }
}
