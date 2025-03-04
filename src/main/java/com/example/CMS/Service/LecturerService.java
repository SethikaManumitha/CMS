package com.example.CMS.Service;

import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Repository.LecturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepo lecturerRepo;

    /**
     * Saves lecturer details to the database.
     * @param lecturer Admin entity to be saved
     * @return Saved Lecturer entity
     */
    public Lecturer saveLecturer(Lecturer lecturer){
        return lecturerRepo.save(lecturer);
    }

    /**
     * Fetches a lecturer by ID.
     * @param id Lecturer ID
     * @return Lecturer entity
     */
    public Lecturer getLecturerById(int id) {
        return lecturerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));
    }

    /**
     * Fetches all lecturers.
     * @return List of all Lecturer entities
     */
    public List<Lecturer> getAllLecturers() {
        return lecturerRepo.findAll();
    }

    /**
     * Updates an existing lecturer by ID.
     * @param id Lecturer ID
     * @param lecturer Lecturer entity with updated data
     * @return Updated Lecturer entity
     */
    public Lecturer updateLecturer(int id, Lecturer lecturer) {
        Lecturer existingLecturer = lecturerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));

        // Update lecturer fields as needed
        //existingLecturer.setUser(lecturer.getUser());
        //existingLecturer.setDepartment(lecturer.getDepartment());
        existingLecturer.setDesignation(lecturer.getDesignation());
        existingLecturer.setSpecialization(lecturer.getSpecialization());
        existingLecturer.setHighestQualification(lecturer.getHighestQualification());

        return lecturerRepo.save(existingLecturer);
    }

    /**
     * Deletes a lecturer by ID.
     * @param id Lecturer ID
     */
    public void deleteLecturer(int id) {
        if (!lecturerRepo.existsById(id)) {
            throw new RuntimeException("Lecturer not found");
        }
        lecturerRepo.deleteById(id);
    }

}
