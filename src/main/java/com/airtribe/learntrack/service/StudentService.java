package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private final Map<Integer, Student> students = new HashMap<>();

    public Student addStudent(Student student) {
        student.setId(IdGenerator.nextId());
        students.put(student.getId(), student);
        return student;
    }

    public Student getStudent(int id) {
        Student student = students.get(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found");
        }
        return student;
    }
}
