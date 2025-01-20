package com.example.socialmediaplatform.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleException(RuntimeException ex, WebRequest request) {

        ApiError error;
        if (ex instanceof ResourceNotFoundException) {
            error = new ApiError(HttpStatus.NOT_FOUND, "Unable to find the requested resource.", ex);
        } else if (ex instanceof ResourceAlreadyExistsException) {
            error = new ApiError(HttpStatus.NOT_FOUND, "The Resource is Already present", ex);
        } else {
            error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error while processing.", ex);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(error, headers, error.getStatus());
    }

}

