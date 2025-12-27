package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public void delete(Student student) {
        students.remove(student);
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public List<Student> findActiveStudents() {
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
        throw new EntityNotFoundException("Student with ID " + id + " not found");
    }
}
