package com.example.CMS.Controller;

import com.example.CMS.Entity.Course;
import com.example.CMS.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling course-related API endpoints.
 * Manages HTTP requests related to course entity operations.
 */
@RestController
@RequestMapping("courses") //Added request mapping
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * Handles HTTP POST requests to add a new degree Program.
     * @param course department entity received in the request body
     * @return Saved degree Program entity
     */

    @PostMapping // Made constant format
    public Course postDetails(@RequestBody Course course)
    {

        return courseService.saveDetails(course);
    }
}
