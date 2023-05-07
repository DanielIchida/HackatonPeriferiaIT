package com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAdn {

    @NotNull(message = "Debes ingresar una cadena DNA")
    private String[] dna;

}
