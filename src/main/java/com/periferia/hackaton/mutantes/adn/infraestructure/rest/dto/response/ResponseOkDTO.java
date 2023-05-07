package com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response;

public class ResponseOkDTO extends ResponseDTO {
    public ResponseDTO message(Object result) {
        setError("");
        setMessage("OK");
        setData(result);
        return this;
    }
}
