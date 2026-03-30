package com.ferreira_gn.grannix.domain.exception;

public class ProblemNotFoundException extends RuntimeException {
    public ProblemNotFoundException(String message) {
        super(message);
    }

    public ProblemNotFoundException() {
        super("The problem was not found.");
    }
}
