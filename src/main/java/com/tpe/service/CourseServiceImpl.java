package com.tpe.service;

import com.tpe.domain.Course;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository repository;

    @Override
    public void saveCourse(Course course) {
        repository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.getAll();
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = findCourseById(id);
        repository.delete(course.getId());
    }

    @Override
    public Course findCourseById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Course object not found with id "+id));
    }

}
