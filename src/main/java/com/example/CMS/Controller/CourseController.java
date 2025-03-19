package com.example.CMS.Controller;

import com.example.CMS.Entity.*;
import com.example.CMS.Service.CourseService;
import com.example.CMS.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

        // Set the fetched lecturer to the course
        Course course = new Course();

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

    @GetMapping("/{courseId}/degree-programs")
    public ResponseEntity<List<DegreeProgram>> getDegreeProgramsForCourse(@PathVariable int courseId) {
        List<DegreeProgram> degreePrograms = courseService.getDegreeProgramsForCourse(courseId);
        return ResponseEntity.ok(degreePrograms);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id,@RequestBody Course courseRequest) {
        Course existingCourse = courseService.getCourseById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existingCourse.setCourseName(courseRequest.getCourseName());
        existingCourse.setCredits(courseRequest.getCredits());
        existingCourse.setStatus(courseRequest.getStatus());
        // Save the updated course back to the repository
        return courseService.saveDetails(existingCourse);
    }
}
