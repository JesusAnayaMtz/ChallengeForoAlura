package com.challengeforoalura.foroalura.infra.errors;

import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class HandleCustomErrors {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity customErrorArgumentNotValid(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().map(DataValidationError::new).toList();

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handleSqlIntegritiConstraint(SQLIntegrityConstraintViolationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleValidationException(ValidationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record DataValidationError(String field, String error){
        public DataValidationError(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
