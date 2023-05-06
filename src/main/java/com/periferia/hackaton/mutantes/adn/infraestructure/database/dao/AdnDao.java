package com.periferia.hackaton.mutantes.adn.infraestructure.database.dao;

import com.periferia.hackaton.mutantes.adn.infraestructure.database.models.AdnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdnDao extends JpaRepository<AdnEntity,Long> {

    @Query("SELECT COUNT(a) FROM AdnEntity a WHERE a.isMutant = ?1")
    int countByIsMutant(Boolean isMutant);

    @Query("SELECT a FROM AdnEntity a WHERE a.chains = ?1")
    Optional<AdnEntity> exists(String dna);

}
