package com.periferia.hackaton.mutantes.adn.domain.events;

public interface OnResponseMutantStats {
    void onCallback(int humans,int mutants,float ratio);
}
