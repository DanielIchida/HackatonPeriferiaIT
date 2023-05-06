package com.periferia.hackaton.mutantes.adn.infraestructure.database.datasources;

import com.periferia.hackaton.mutantes.adn.application.repository.AdnRepository;
import com.periferia.hackaton.mutantes.adn.infraestructure.database.dao.AdnDao;
import com.periferia.hackaton.mutantes.adn.infraestructure.database.models.AdnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdnDataSources implements AdnRepository {

    private final AdnDao adnDao;
    @Autowired
    public AdnDataSources(AdnDao adnDao){
        this.adnDao = adnDao;
    }

    @Override
    public void save(String chain, boolean isMutant) {
        AdnEntity adn = new AdnEntity();
        adn.setChains(chain);
        adn.setMutant(isMutant);
        adnDao.save(adn);
    }

    @Override
    public int countMutants(boolean isMutant) {
        return adnDao.countByIsMutant(isMutant);
    }

    @Override
    public boolean exist(String chain) {
        return adnDao.exists(chain).isPresent();
    }
}
