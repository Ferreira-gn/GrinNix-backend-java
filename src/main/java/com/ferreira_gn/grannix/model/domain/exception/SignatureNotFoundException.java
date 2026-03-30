package com.ferreira_gn.grannix.model.domain.exception;

public class SignatureNotFoundException extends RuntimeException {
    public SignatureNotFoundException(String message) {
        super(message);
    }

    public SignatureNotFoundException() {
        super("The signature was not found.");
    }
}
