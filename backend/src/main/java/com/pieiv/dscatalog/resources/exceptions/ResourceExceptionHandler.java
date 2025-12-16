package com.pieiv.dscatalog.resources.exceptions;

import com.pieiv.dscatalog.entities.Category;
import com.pieiv.dscatalog.services.exceptions.ResourceNotFoundExcpetion;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExcpetion.class)
    public ResponseEntity<StandardError> entityNotFound(Category category, HttpStatus status){
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Category Not Found");
        err.setMessage(err.getMessage());
        HttpServletRequest request;
        return new ResponseEntity<>(err, status);
    }
}
