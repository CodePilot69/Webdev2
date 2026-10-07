package com.webdev2;

/**
 * Gradable interface — any class that implements this must provide
 * a way to compute the academic standing of a student.
 */
public interface Gradable {

    /**
     * Computes and returns the academic standing label
     * (e.g. "Freshman", "Sophomore", "Junior", "Senior").
     *
     * @return a String describing the student's academic standing
     */
    String computeStanding();
}
