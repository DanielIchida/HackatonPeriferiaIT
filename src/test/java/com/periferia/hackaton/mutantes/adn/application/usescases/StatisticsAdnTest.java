package com.periferia.hackaton.mutantes.adn.application.usescases;

import com.periferia.hackaton.mutantes.adn.domain.events.OnResponseMutantStats;
import com.periferia.hackaton.mutantes.adn.domain.services.AdnServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StatisticsAdnTest {

    @InjectMocks
    private StatisticsAdn statisticsAdn;

    @Mock
    AdnServices adnServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateStat(){
        OnResponseMutantStats responseMutantStats = (humans, mutants, ratio) -> {};
        adnServices.statistics(responseMutantStats);
        statisticsAdn.execute();
        Assertions.assertEquals(statisticsAdn.getCountHuman(),0);
        Assertions.assertEquals(statisticsAdn.getCountMutant(),0);
        Assertions.assertEquals(statisticsAdn.getRatio(),0.0);
    }

}
