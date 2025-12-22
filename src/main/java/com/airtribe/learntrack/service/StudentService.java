package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public Student addStudent(String firstName, String lastName, String batch) {
        Student student = new Student(
                IdGenerator.getNextStudentId(),
                firstName,
                lastName,
                batch
        );
        students.add(student);
        return student;
    }

    public Student addStudent(String firstName, String lastName, String email, String batch) {
        Student student = new Student(
                IdGenerator.getNextStudentId(),
                firstName,
                lastName,
                email,
                batch
        );
        students.add(student);
        return student;
    }

 
}
