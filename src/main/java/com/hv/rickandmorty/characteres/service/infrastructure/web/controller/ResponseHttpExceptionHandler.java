package com.hv.rickandmorty.characteres.service.infrastructure.web.controller;

import com.hv.rickandmorty.characteres.service.domain.exception.CharacterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ResponseHttpExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        var path = ((ServletWebRequest)request).getRequest().getRequestURI();
        var errorResponse = new ErrorResponse("internal:Error","Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(),path);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CharacterNotFoundException.class)
    public final ResponseEntity<ErrorResponse> notFoundCharacterException(Exception ex, WebRequest request) {
        var path = ((ServletWebRequest)request).getRequest().getRequestURI();
        var errorResponse = new ErrorResponse("request:Error","Not Found Character",HttpStatus.NOT_FOUND.value(),"Not found character with the given name",path);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
