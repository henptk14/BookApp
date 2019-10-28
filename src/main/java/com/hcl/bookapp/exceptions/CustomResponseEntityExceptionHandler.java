package com.hcl.bookapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<CustomExceptionResponse> handleException(CustomException ex, WebRequest req) {
        CustomExceptionResponse cr = new CustomExceptionResponse(ex.getMessage());

        return new ResponseEntity<CustomExceptionResponse>(cr, HttpStatus.BAD_REQUEST);
    }
}
