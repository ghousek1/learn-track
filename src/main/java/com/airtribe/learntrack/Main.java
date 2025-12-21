package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        Scanner sc = new Scanner(System.in);

        Student student = new Student("Tony", "Ghouse", "B1");
        studentService.addStudent(student);

        Course course = new Course("Java Backend", "Spring and Core Java", 12);
        courseService.addCourse(course);

        enrollmentService.enroll(student.getId(), course.getId());

        System.out.println("Student enrolled successfully");
    }
}
