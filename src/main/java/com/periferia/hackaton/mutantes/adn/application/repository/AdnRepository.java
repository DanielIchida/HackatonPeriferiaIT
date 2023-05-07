package com.periferia.hackaton.mutantes.adn.application.repository;


public interface AdnRepository {
    void save(String chain,boolean isMutant);
    int countMutants(boolean isMutant);

    boolean exist(String chain);
}
