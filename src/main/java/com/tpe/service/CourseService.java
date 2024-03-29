package com.tpe.service;

import com.tpe.domain.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    List<Course>getAllCourses();
    void deleteCourse(Long id);

    Course findCourseById(Long id);

}
