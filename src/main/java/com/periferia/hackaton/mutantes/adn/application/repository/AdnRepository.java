package com.periferia.hackaton.mutantes.adn.application.repository;

import com.periferia.hackaton.mutantes.adn.domain.entities.Adn;

public interface AdnRepository {
    void save(String chain,boolean isMutant);
    int countMutants(boolean isMutant);

    boolean exist(String chain);
}
