package com.periferia.hackaton.mutantes.adn.application.usescases;

import com.periferia.hackaton.mutantes.adn.domain.services.AdnServices;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsAdn {

    private final AdnServices adnServices;
    private int countHuman;
    private int countMutant;
    private float ratio;

    public StatisticsAdn(AdnServices adnServices) {
        this.adnServices = adnServices;
        this.countHuman = 0;
        this.countMutant = 0;
        this.ratio = 0.0f;
    }

    public void execute() {
        adnServices.statistics(((humans, mutants, r) -> {
            setCountHuman(humans);
            setCountMutant(mutants);
            setRatio(r);
        }));
    }
}
