package com.example.CMS.Controller;

import com.example.CMS.Entity.DegreeProgram;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Service.DegreeProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling degree Program-related API endpoints.
 * Manages HTTP requests related to degree Program entity operations.
 */
@RestController
@RequestMapping("/degreeProgrammes") // Added request mapping
public class DegreeProgramController {
    @Autowired
    private DegreeProgramService degreeProgramService;

    /**
     * Handles HTTP POST requests to add a new degree Program.
     * @param degreeProgram department entity received in the request body
     * @return Saved degree Program entity
     */

    @PostMapping
    public DegreeProgram postDetails(@RequestBody DegreeProgram degreeProgram)
    {
        return degreeProgramService.saveDetails(degreeProgram);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable int id) {
        degreeProgramService.deleteDegreeProgram(id);
    }

    @GetMapping
    public List<DegreeProgram> getAllProgrammes() {
        return degreeProgramService.getAllProgrammes();
    }

    // PUT Endpoint to Assign Courses to a Degree Program
    @PutMapping("/{programId}/courses")
    public DegreeProgram assignCoursesToDegreeProgram(
            @PathVariable int programId,
            @RequestBody List<Integer> courseIds) {
        return degreeProgramService.assignCourses(programId, courseIds);
    }
}
