package com.webdev2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages a collection of Student objects using generics.
 * Uses List<Student> (not a raw type) throughout.
 */
public class Roster {

    // Generic typed list — satisfies the "no raw types" requirement
    private final List<Student> students = new ArrayList<>();

    /**
     * Adds a student to the roster.
     *
     * @param student the Student to add
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Returns the full list of students.
     *
     * @return unmodifiable view of the student list
     */
    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    /**
     * Prints every student in the roster to standard output.
     */
    public void printAll() {
        System.out.println("=== Full Roster (" + students.size() + " students) ===");
        students.forEach(System.out::println);
    }

    // ── Task 5: Stream-based Roster Report ────────────────────────────────────

    /**
     * Filters students who are 18 or older, maps them to name strings,
     * prints the names, and prints the count of qualifying students.
     */
    public void printAdultReport() {
        System.out.println("\n=== Students Aged 18 or Older ===");

        List<String> adultNames = students.stream()
                .filter(s -> s.getAge() >= 18)          // (a) filter by age
                .map(Student::getName)                   // (b) map to name only
                .collect(Collectors.toList());           // terminal operation

        adultNames.forEach(System.out::println);

        // (c) count of students who qualified
        System.out.println("Total qualifying students (age >= 18): " + adultNames.size());
    }
}
