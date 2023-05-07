package com.periferia.hackaton.mutantes.adn.domain.services.search;

import lombok.Getter;

public abstract class SearchPosition {

    protected String[] dna;
    protected PositionEnum positionEnum;

    public SearchPosition(String[] dna, PositionEnum positionEnum) {
        this.dna = dna;
        this.positionEnum = positionEnum;
    }

    public abstract int numMatches();



}
