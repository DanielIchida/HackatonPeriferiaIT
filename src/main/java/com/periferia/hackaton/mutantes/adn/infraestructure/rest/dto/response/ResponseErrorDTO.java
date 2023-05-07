package com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response;

public class ResponseErrorDTO extends ResponseDTO {
    public ResponseDTO message(String error) {
        setError(error);
        setMessage("ERROR");
        setData(null);
        return this;
    }
}
