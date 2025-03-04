package com.example.CMS.Controller;

import com.example.CMS.Entity.DegreeProgram;
import com.example.CMS.Service.DegreeProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling degree Program-related API endpoints.
 * Manages HTTP requests related to degree Program entity operations.
 */
@RestController
@RequestMapping("/degreeProgramme") // Added request mapping
public class DegreeProgramController {
    @Autowired
    private DegreeProgramService degreeProgramService;

    /**
     * Handles HTTP POST requests to add a new degree Program.
     * @param degreeProgram department entity received in the request body
     * @return Saved degree Program entity
     */

    @PostMapping("/addDegreeProgram")
    public DegreeProgram postDetails(@RequestBody DegreeProgram degreeProgram)
    {

        return degreeProgramService.saveDetails(degreeProgram);
    }
}
