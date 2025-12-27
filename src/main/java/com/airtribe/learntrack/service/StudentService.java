package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    public Student addStudent(String firstName, String lastName, String batch) {
        Student student = new Student(
                IdGenerator.getNextStudentId(),
                firstName,
                lastName,
                batch
        );
        studentRepository.save(student);
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
        studentRepository.save(student);
        return student;
    }

    public void removeStudent(int id) {
        Student student = studentRepository.findById(id);
        studentRepository.delete(student);
    }

    public void updateStudent(int id, String batch) {
        Student student = studentRepository.findById(id);
        student.setBatch(batch);
    }

    public void updateStudent(int id, String email, boolean active) {
        Student student = studentRepository.findById(id);
        student.setEmail(email);
        student.setActive(active);
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    public List<Student> listActiveStudents() {
        return studentRepository.findActiveStudents();
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id);
    }

    public void deactivateStudent(int id) {
        Student student = studentRepository.findById(id);
        student.setActive(false);
    }
}
