package com.ferreira_gn.grannix.model.domain.exception;

public class ProblemNotFoundException extends RuntimeException {
    public ProblemNotFoundException(String message) {
        super(message);
    }

    public ProblemNotFoundException() {
        super("The problem was not found.");
    }
}
