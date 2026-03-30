package com.ferreira_gn.grannix.domain.exception;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException() {
    super("The problem was not found.");
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
