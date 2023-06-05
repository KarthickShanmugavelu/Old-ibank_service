package com.ibank.service.exceptionHandling;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandling {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomMessage> exceptionHandling(Exception e){
        return new ResponseEntity<>(new CustomMessage(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
