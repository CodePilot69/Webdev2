package com.webdev2;

/**
 * Represents a student with encapsulated fields.
 * Implements Gradable to provide academic standing computation.
 */
public class Student implements Gradable {

    // Private fields — enforces encapsulation
    private String name;
    private int    age;
    private String course;

    /**
     * Parameterized constructor.
     *
     * @param name   the student's full name
     * @param age    the student's age (must be non-negative)
     * @param course the student's enrolled course/program
     * @throws InvalidAgeException if age is negative
     */
    public Student(String name, int age, String course) {
        this.name   = name;
        this.course = course;
        setAge(age); // delegate to setter so validation is always applied
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    // ── Setters ──────────────────────────────────────────────────────────────

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the student's age.
     * Throws InvalidAgeException if the supplied value is negative.
     *
     * @param age the age to set
     * @throws InvalidAgeException if age < 0
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new InvalidAgeException(
                "Invalid age: " + age + ". Age cannot be negative."
            );
        }
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // ── Gradable implementation ───────────────────────────────────────────────

    /**
     * Returns the student's academic standing based on age.
     * A real system would use credit hours; age is used here as a proxy.
     *
     * @return standing label
     */
    @Override
    public String computeStanding() {
        if (age < 18) {
            return "Pre-College";
        } else if (age <= 19) {
            return "Freshman";
        } else if (age <= 20) {
            return "Sophomore";
        } else if (age <= 21) {
            return "Junior";
        } else {
            return "Senior";
        }
    }

    // ── toString ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return String.format(
            "Student{name='%s', age=%d, course='%s', standing='%s'}",
            name, age, course, computeStanding()
        );
    }
}
