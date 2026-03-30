package com.ferreira_gn.grannix.model.domain.exception;

public class TestsCasesNotFoundException extends RuntimeException {
    public TestsCasesNotFoundException(String message) {
        super(message);
    }

    public TestsCasesNotFoundException() {
        super("The test case was not found.");
    }
}