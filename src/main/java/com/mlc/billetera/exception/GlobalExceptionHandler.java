package com.mlc.billetera.exception;

import com.mlc.billetera.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO manejarRuntimeException(RuntimeException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ex.getMessage());
        return error;
    }
}
