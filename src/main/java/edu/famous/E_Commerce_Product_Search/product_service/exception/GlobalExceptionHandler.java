package edu.famous.E_Commerce_Product_Search.product_service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.sql.Timestamp;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(RuntimeException ex, WebRequest request) {
        log.error("Runtime exception occurred: {}", ex.getMessage(), ex);
        return ErrorResponse.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        log.error("Validation exception occurred: {}", ex.getMessage(), ex);
        return ErrorResponse.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getBindingResult().getFieldErrors().stream()
                        .map(error -> error.getField() + ": " + error.getDefaultMessage())
                        .reduce((msg1, msg2) -> msg1 + ", " + msg2).orElse("Validation error"))
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ErrorResponse handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        log.error("Access denied exception occurred: {}", ex.getMessage(), ex);
        return ErrorResponse.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(HttpStatus.FORBIDDEN.value())
                .error(HttpStatus.FORBIDDEN.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
    }
}
