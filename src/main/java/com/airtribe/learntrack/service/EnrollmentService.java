package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private final List<Enrollment> enrollments = new ArrayList<>();

    public Enrollment enrollStudent(int studentId, int courseId) {
        Enrollment enrollment = new Enrollment(studentId, courseId);
        enrollment.setId(IdGenerator.getNextEnrollmentId());
        enrollments.add(enrollment);
        return enrollment;
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public void updateStatus(int enrollmentId, EnrollmentStatus status) {
        Enrollment enrollment = findById(enrollmentId);
        enrollment.setStatus(status);
    }

    public List<Enrollment> listAll() {
        return new ArrayList<>(enrollments);
    }

    private Enrollment findById(int id) {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new RuntimeException("Enrollment not found");
    }
}
