package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private final List<Course> courses = new ArrayList<>();

    public Course addCourse(String name, String description, int duration) {
        Course course = new Course(name, description, duration);
        course.setId(IdGenerator.getNextCourseId());
        courses.add(course);
        return course;
    }


    public List<Course> listCourses() {
        return new ArrayList<>(courses);
    }



    private Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        throw new EntityNotFoundException("Course not found");
    }
}
