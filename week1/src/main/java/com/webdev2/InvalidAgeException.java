package com.webdev2;

/**
 * Custom unchecked exception thrown when a student's age is set to
 * a negative value.
 *
 * Extends RuntimeException so callers are not forced to declare it,
 * but it can still be caught and handled explicitly in Main.
 */
public class InvalidAgeException extends RuntimeException {

    /**
     * @param message a human-readable explanation of why the age is invalid
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}
