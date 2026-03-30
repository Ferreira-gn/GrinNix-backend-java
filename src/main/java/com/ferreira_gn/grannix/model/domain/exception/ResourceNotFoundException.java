package com.ferreira_gn.grannix.model.domain.exception;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException() {
    super("The problem was not found.");
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
