package com.jonareas.techhub.exceptions;

public class ModelNotFoundException extends Exception {

    public static String identifierNotFoundMessage(Long id) {
        return ID_NOT_FOUND_MESSAGE + id;
    }

    private static final String ID_NOT_FOUND_MESSAGE = "ID Not Found: ";

    public ModelNotFoundException(String message) {
        super(message);
    }
}
