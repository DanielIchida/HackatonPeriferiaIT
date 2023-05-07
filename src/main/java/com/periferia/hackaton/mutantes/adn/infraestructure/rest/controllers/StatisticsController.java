package com.periferia.hackaton.mutantes.adn.infraestructure.rest.controllers;

import com.periferia.hackaton.mutantes.adn.application.usescases.StatisticsAdn;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response.StatisticsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController extends BaseController{

    private final StatisticsAdn statisticsAdn;

    @Autowired
    public StatisticsController(StatisticsAdn statisticsAdn) {
        this.statisticsAdn = statisticsAdn;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> status() {
        StatisticsDTO statisticsDTO = new StatisticsDTO();
        statisticsAdn.execute();
        statisticsDTO.setCountHumanDna(statisticsAdn.getCountHuman());
        statisticsDTO.setCountMutantDna(statisticsAdn.getCountMutant());
        statisticsDTO.setRatio(statisticsAdn.getRatio());
        return oKMessage(statisticsDTO);
    }
}
