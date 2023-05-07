package com.periferia.hackaton.mutantes.adn.infraestructure.database.datasources;


import com.google.gson.Gson;
import com.periferia.hackaton.mutantes.adn.infraestructure.database.dao.AdnDao;
import com.periferia.hackaton.mutantes.adn.infraestructure.database.models.AdnEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AdnDataSourcesTest {

    @InjectMocks
    AdnDataSources adnDataSources;

    @Mock
    AdnDao adnDao;

    String[] chain;
    String chainToString;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
        chain  = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        chainToString = new Gson().toJson(chain);
    }

    @Test
    void saveTest() {
        AdnEntity dna = Mockito.mock(AdnEntity.class);
        Mockito.when(adnDao.save(dna)).thenReturn(dna);
        adnDataSources.save(chainToString,false);
        verify(adnDao).save(Mockito.any(AdnEntity.class));
        verify(adnDao, times(1)).save(Mockito.any(AdnEntity.class));
    }

    @Test
    void countMutantsTest() {
       Mockito.when(adnDao.countByIsMutant(true)).thenReturn(2);
       int countMutant = adnDataSources.countMutants(true);
       verify(adnDao).countByIsMutant(true);
       verify(adnDao, times(1)).countByIsMutant(true);
       Assertions.assertEquals(countMutant,2);
    }

    @Test
    void existTest() {
       AdnEntity dna = Mockito.mock(AdnEntity.class);
       Mockito.when(adnDao.exists(chainToString)).thenReturn(Optional.of(dna));
       boolean dnaResult = adnDataSources.exist(chainToString);
       verify(adnDao).exists(chainToString);
       verify(adnDao, times(1)).exists(chainToString);
       Assertions.assertTrue(dnaResult);
    }


}
