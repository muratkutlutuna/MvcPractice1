package com.tpe.controller;


import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/form")
    public String showCoursesForm(@ModelAttribute("course") Course course){
        return "courseForm";
    }

    @PostMapping("/saveCourse")
    public String createCourse(@Valid @ModelAttribute Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "courseForm";
        }
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping
    public ModelAndView getCourses(){
        List<Course> courseList = courseService.getAllCourses();
        ModelAndView mav = new ModelAndView();
        mav.addObject("courses", courseList);
        mav.setViewName("courses");
        return mav;
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        Course course = courseService.findCourseById(id);
        model.addAttribute("course", course);
        return "courseForm";
    }

}
