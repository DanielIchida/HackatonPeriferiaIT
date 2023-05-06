package com.periferia.hackaton.mutantes.adn.application.usescases;

import com.periferia.hackaton.mutantes.adn.domain.entities.Adn;
import com.periferia.hackaton.mutantes.adn.domain.services.AdnServices;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveAdn {

    private final AdnServices adnServices;
    private boolean isValidateMutant;

    public SaveAdn(AdnServices adnServices) {
        this.adnServices = adnServices;
        this.isValidateMutant = false;
    }

    public void execute(String[] dna) {
        Adn adn = new Adn();
        adn.setDna(dna);
        adnServices.save(adn, this::setValidateMutant);
    }

}
