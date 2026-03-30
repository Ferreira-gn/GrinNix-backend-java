package com.ferreira_gn.grannix.domain.exception;

public class LanguageNotFoundException extends RuntimeException {
    public LanguageNotFoundException(String message) {
        super(message);
    }

    public LanguageNotFoundException() {
        super("The language was not found.");
    }
}
