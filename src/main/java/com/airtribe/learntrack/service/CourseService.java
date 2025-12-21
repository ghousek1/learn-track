package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class CourseService {
    private final Map<Integer, Course> courses = new HashMap<>();

    public Course addCourse(Course course) {
        course.setId(IdGenerator.nextId());
        courses.put(course.getId(), course);
        return course;
    }

    public Course getCourse(int id) {
        Course course = courses.get(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found");
        }
        return course;
    }
}
