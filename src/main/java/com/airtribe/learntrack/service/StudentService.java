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

    public void removeStudent(int id) {
        Student student = findById(id);
        students.remove(student);
    }

    public void updateStudent(int id, String batch) {
        Student student = findById(id);
        student.setBatch(batch);
    }

    public void updateStudent(int id, String email, boolean active) {
        Student student = findById(id);
        student.setEmail(email);
        student.setActive(active);
    }

    public List<Student> listStudents() {
        return new ArrayList<>(students);
    }

    public List<Student> listActiveStudents() {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.isActive()) {
                result.add(student);
            }
        }
        return result;
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new EntityNotFoundException("Student not found");
    }
}
