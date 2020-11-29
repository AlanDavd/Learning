package com.company.importer;

public class UnknownFileTypeException extends RuntimeException {
    public UnknownFileTypeException(final String message) {
        super(message);
    }
}
