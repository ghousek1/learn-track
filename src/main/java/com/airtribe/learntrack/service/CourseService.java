package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository = new CourseRepository();

    public Course addCourse(String name, String description, int duration) {
        Course course = new Course(name, description, duration);
        course.setId(IdGenerator.getNextCourseId());
        courseRepository.save(course);
        return course;
    }

    public void deactivateCourse(int id) {
        Course course = courseRepository.findById(id);
        course.setActive(false);
    }

    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    public List<Course> listActiveCourses() {
        return courseRepository.findActiveCourses();
    }

    public Course getCourse(int id) {
        return courseRepository.findById(id);
    }
}
