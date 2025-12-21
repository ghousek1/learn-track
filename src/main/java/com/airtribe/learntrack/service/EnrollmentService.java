package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Enrollment enroll(int studentId, int courseId) {
        Enrollment enrollment = new Enrollment(studentId, courseId);
        enrollment.setId(IdGenerator.nextId());
        enrollments.add(enrollment);
        return enrollment;
    }
}
