package com.ferreira_gn.grannix.domain.exception;

import com.ferreira_gn.grannix.dto.response.error.ErrorResponseDTO;

import java.time.Instant;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponseDTO> handleNotFound(
    ResourceNotFoundException ex
  ) {
    ErrorResponseDTO error = new ErrorResponseDTO(
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      Instant.now()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(BusinessRuleException.class)
  public ResponseEntity<ErrorResponseDTO> handleBusinessRule(
    BusinessRuleException ex
  ) {
    ErrorResponseDTO error = new ErrorResponseDTO(
      HttpStatus.CONFLICT.value(),
      ex.getMessage(),
      Instant.now()
    );
    return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseDTO> handleValidation(
    MethodArgumentNotValidException ex
  ) {
    String message = ex
      .getBindingResult()
      .getFieldErrors()
      .stream()
      .map(error -> error.getField() + ": " + error.getDefaultMessage())
      .collect(Collectors.joining(", "));

    ErrorResponseDTO error = new ErrorResponseDTO(
      HttpStatus.BAD_REQUEST.value(),
      message,
      Instant.now()
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDTO> handleGeneric(Exception ex) {
    ErrorResponseDTO error = new ErrorResponseDTO(
      HttpStatus.INTERNAL_SERVER_ERROR.value(),
      "Ocorreu um erro interno. Tente novamente mais tarde." + ex,
      Instant.now()
    );
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
