package com.webdev2;

/**
 * Entry point for the WebDev2 lab.
 *
 * Demonstrates:
 *  - Roster management with generics (Task 3)
 *  - InvalidAgeException handling (Task 4)
 *  - Stream-based roster report (Task 5)
 */
public class Main {

    public static void main(String[] args) {

        Roster roster = new Roster();

        // ── Task 3: Add at least 6 students ──────────────────────────────────
        roster.addStudent(new Student("Alice Reyes",    20, "Computer Science"));
        roster.addStudent(new Student("Ben Santos",     17, "Information Technology"));
        roster.addStudent(new Student("Clara Mendoza",  22, "Computer Engineering"));
        roster.addStudent(new Student("David Cruz",     19, "Computer Science"));
        roster.addStudent(new Student("Eva Lim",        18, "Software Engineering"));
        roster.addStudent(new Student("Felix Tan",      21, "Information Systems"));

        // Print the full roster
        roster.printAll();

        // ── Task 4: Exception handling for invalid age ────────────────────────
        System.out.println("\n=== Exception Handling Demo ===");
        try {
            // Deliberately pass a negative age to trigger InvalidAgeException
            Student invalid = new Student("Ghost User", -5, "Unknown");
            roster.addStudent(invalid); // this line is never reached
        } catch (InvalidAgeException e) {
            System.out.println("[ERROR] Caught InvalidAgeException: " + e.getMessage());
            System.out.println("[INFO]  Program continues running normally.");
        }

        // ── Task 5: Stream-based report ───────────────────────────────────────
        roster.printAdultReport();
    }
}
