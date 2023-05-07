package com.periferia.hackaton.mutantes.adn.infraestructure.rest.controllers;

import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response.ResponseDTO;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response.ResponseErrorDTO;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response.ResponseOkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adn")
public class BaseController {

    public ResponseEntity<ResponseDTO> errorMessage(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseErrorDTO().message(e.getMessage()));
    }

    public ResponseEntity<ResponseDTO> oKMessage(Object data) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseOkDTO().message(data));
    }

    public ResponseEntity<ResponseDTO> forbiddenMessage(Object data) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseOkDTO().message(data));
    }

}
