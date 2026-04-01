package com.ferreira_gn.grannix.model.domain.exception;

public class SubmissionNotFoundException extends RuntimeException {
    public SubmissionNotFoundException(String message) {
        super(message);
    }

    public SubmissionNotFoundException() {
        super("Submission was not found.");
    }
}
