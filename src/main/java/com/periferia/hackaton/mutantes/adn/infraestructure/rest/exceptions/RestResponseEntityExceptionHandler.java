package com.periferia.hackaton.mutantes.adn.infraestructure.rest.exceptions;

import com.periferia.hackaton.mutantes.adn.domain.execptions.InvalidStructureDnaException;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.response.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidStructureDnaException.class})
    protected ResponseEntity<ResponseDTO> handleWarn(RuntimeException ex, WebRequest webRequest) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(null);
        responseDTO.setError(ex.getMessage());
        responseDTO.setMessage("WARN");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO();
        for (ObjectError methodArgumentNotValidException : ex.getBindingResult().getAllErrors()){
            errors.add(methodArgumentNotValidException.getDefaultMessage());
        }
        responseDTO.setMessage("VALIDATIONS");
        responseDTO.setError(null);
        responseDTO.setData(errors);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
    }

}
