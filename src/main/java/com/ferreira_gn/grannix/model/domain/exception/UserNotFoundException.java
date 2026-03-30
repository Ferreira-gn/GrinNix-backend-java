package com.ferreira_gn.grannix.model.domain.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

  public UserNotFoundException() {
    super("The user was not found.");
  }
}
