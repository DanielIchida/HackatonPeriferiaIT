package com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsDTO {
    private int countMutantDna;
    private int countHumanDna;
    private float ratio;
}
