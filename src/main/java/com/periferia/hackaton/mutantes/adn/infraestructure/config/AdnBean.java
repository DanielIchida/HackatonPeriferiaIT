package com.periferia.hackaton.mutantes.adn.infraestructure.config;

import com.periferia.hackaton.mutantes.adn.application.repository.AdnRepository;
import com.periferia.hackaton.mutantes.adn.application.usescases.SaveAdn;
import com.periferia.hackaton.mutantes.adn.application.usescases.StatisticsAdn;
import com.periferia.hackaton.mutantes.adn.domain.services.AdnServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdnBean {

    @Bean
    public AdnServices adnServices(AdnRepository repository) {
        return new AdnServices(repository);
    }

    @Bean
    public SaveAdn saveAdn(AdnServices adnServices) {
        return new SaveAdn(adnServices);
    }

    @Bean
    public StatisticsAdn statisticsAdn(AdnServices adnServices) {
        return new StatisticsAdn(adnServices);
    }

}
