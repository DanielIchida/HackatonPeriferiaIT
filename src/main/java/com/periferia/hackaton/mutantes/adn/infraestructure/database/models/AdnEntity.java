package com.periferia.hackaton.mutantes.adn.infraestructure.database.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "adn")
@Getter
@Setter
public class AdnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String chains;

    @Column(name = "is_mutant")
    private boolean isMutant;

}
