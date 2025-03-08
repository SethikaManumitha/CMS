package com.example.CMS.Controller;

import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Service.CourseService;
import com.example.CMS.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling course-related API endpoints.
 * Manages HTTP requests related to course entity operations.
 */
@RestController
@RequestMapping("courses") //Added request mapping
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private LecturerService lecturerService;

    /**
     * Handles HTTP POST requests to add a new degree Program.
     * @param courseRequest department entity received in the request body
     * @return Saved degree Program entity
     */

    @PostMapping
    public Course addCourse(@RequestBody Course courseRequest) {
        // Ensure that the required fields are not null
        if (courseRequest.getCourseName() == null || courseRequest.getCourseName().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }

        if (courseRequest.getCredits() <= 0) {
            throw new IllegalArgumentException("Credits must be greater than 0");
        }

        Lecturer lecturer =  lecturerService.getLecturerById(courseRequest.getLecturer().getLecturerID())
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));

        // Set the fetched lecturer to the course
        Course course = new Course();
        course.setLecturer(lecturer);

        // Set course properties
        course.setCourseName(courseRequest.getCourseName());
        course.setCredits(courseRequest.getCredits());
        if (courseRequest.getStatus() != null) {
            course.setStatus(courseRequest.getStatus());
        }

        if (courseRequest.getDegreePrograms() != null) {
            course.setDegreePrograms(courseRequest.getDegreePrograms());
        }

        return courseService.saveDetails(course);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return  courseService.getAllCourses();
    }

}
