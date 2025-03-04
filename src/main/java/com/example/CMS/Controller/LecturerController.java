package com.example.CMS.Controller;

import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling Lecturer related API endpoints.
 */
@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    /**
     * Handles HTTP POST requests to add a new lecturer.
     * @param lecturer Lecturer entity received in the request body
     * @return Saved Lecturer entity
     */
    @PostMapping("/addLecturer")
    public Lecturer addLecturer(@RequestBody Lecturer lecturer) {
        return lecturerService.saveLecturer(lecturer);
    }

    /**
     * Handles HTTP GET requests to fetch a lecturer by ID.
     * @param id Lecturer ID
     * @return Lecturer entity
     */
    @GetMapping("/getLecturer/{id}")
    public Lecturer getLecturerById(@PathVariable int id) {
        return lecturerService.getLecturerById(id);
    }

    /**
     * Handles HTTP GET requests to fetch all lecturers.
     * @return List of all Lecturer entities
     */
    @GetMapping("/getAllLecturers")
    public List<Lecturer> getAllLecturers() {
        return lecturerService.getAllLecturers();
    }

    /**
     * Handles HTTP PUT requests to update an existing lecturer.
     * @param id Lecturer ID
     * @param lecturer Lecturer entity with updated data
     * @return Updated Lecturer entity
     */
    @PutMapping("/updateLecturer/{id}")
    public Lecturer updateLecturer(@PathVariable int id, @RequestBody Lecturer lecturer) {
        return lecturerService.updateLecturer(id, lecturer);
    }

    /**
     * Handles HTTP DELETE requests to delete a lecturer by ID.
     * @param id Lecturer ID
     */
    @DeleteMapping("/deleteLecturer/{id}")
    public void deleteLecturer(@PathVariable int id) {
        lecturerService.deleteLecturer(id);
    }
}
