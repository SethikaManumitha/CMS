package com.example.CMS.Controller;

import com.example.CMS.Entity.DegreeProgramCourse;
import com.example.CMS.Service.DegreeProgramCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling degree Program course-related API endpoints.
 * Manages HTTP requests related to degree Program course entity operations.
 */
@RestController
public class DegreeProgramCourseController {
    @Autowired
    private DegreeProgramCourseService degreeProgramCourseService;

    /**
     * Handles HTTP POST requests to add a new degree Program course.
     * @param degreeProgramCourse degree program course entity received in the request body
     * @return Saved degree Program course entity
     */

    @PostMapping("/addDegreeProgramCourse")
    public DegreeProgramCourse postDetails(@RequestBody DegreeProgramCourse degreeProgramCourse) {

        return degreeProgramCourseService.saveDetails(degreeProgramCourse);
    }
}
