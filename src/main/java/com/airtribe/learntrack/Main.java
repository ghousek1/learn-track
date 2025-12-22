package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        Student s1 = studentService.addStudent("Tony", "Ghouse", "B1");
        Student s2 = studentService.addStudent("Rohit", "Sharma", "rohit@mail.com", "B2");
        Student s3 = studentService.addStudent("Virak", "Kohli", "B1");

        studentService.updateStudent(s1.getId(), "B3");
        studentService.updateStudent(s2.getId(), "updated@mail.com", false);

        courseService.addCourse("Java Backend", "Core + Spring", 12);
        courseService.addCourse("System Design", "Scalable systems", 8);

        enrollmentService.enrollStudent(s1.getId(), 1);
        enrollmentService.enrollStudent(s3.getId(), 2);

        for (Student student : studentService.listStudents()) {
            System.out.println(student.getDisplayName());
        }

        for (Student student : studentService.listActiveStudents()) {
            System.out.println("Active: " + student.getDisplayName());
        }
    }
}
