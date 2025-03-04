package com.example.CMS.Service;

import com.example.CMS.Entity.DegreeProgramCourse;
import com.example.CMS.Repository.DegreeProgramCourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling business logic related to Degree program course entity.
 * Provides methods to interact with the Degree program course repository.
 */
@Service
public class DegreeProgramCourseService {
    @Autowired
    private DegreeProgramCourseRepo degreeProgramCourseRepo; // Injecting DegreeProgramCourse dependency

    /**
     * Saves degreeProgramCourse details to the database.
     * @param degreeProgramCourse degreeProgramCourse entity to be saved
     * @return Saved degreeProgramCourse entity
     */
    public DegreeProgramCourse saveDetails(DegreeProgramCourse degreeProgramCourse) {
        return degreeProgramCourseRepo.save(degreeProgramCourse);
    }
}
