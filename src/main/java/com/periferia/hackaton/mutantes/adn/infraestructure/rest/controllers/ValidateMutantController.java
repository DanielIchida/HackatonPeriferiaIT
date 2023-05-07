package com.periferia.hackaton.mutantes.adn.infraestructure.rest.controllers;

import com.periferia.hackaton.mutantes.adn.application.usescases.SaveAdn;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.request.RequestAdn;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response.ResponseDTO;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response.ValidateAdnDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateMutantController extends BaseController{

    private final SaveAdn saveAdn;

    @Autowired
    public ValidateMutantController(SaveAdn saveAdn) {
        this.saveAdn = saveAdn;
    }

    @PostMapping("/mutant")
    public ResponseEntity<ResponseDTO> valid(@Valid @RequestBody RequestAdn requestAdn) {
        ValidateAdnDTO validateAdnDTO = new ValidateAdnDTO();
        saveAdn.execute(requestAdn.getDna());
        validateAdnDTO.setMutant(saveAdn.isValidateMutant());
        if(validateAdnDTO.isMutant()) {
            return oKMessage(validateAdnDTO);
        }
        return forbiddenMessage(validateAdnDTO);
    }

}

