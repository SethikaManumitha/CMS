package com.example.CMS.Service;

import com.example.CMS.Entity.DegreeProgram;
import com.example.CMS.Repository.DegreeProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling business logic related to Degree program entity.
 * Provides methods to interact with the Degree program repository.
 */
@Service
public class DegreeProgramService {
    @Autowired
    private DegreeProgramRepo degreeProgramRepo; // Injecting DegreeProgramRepo dependency

    /**
     * Saves DegreeProgram details to the database.
     * @param degreeProgram department entity to be saved
     * @return Saved department entity
     */
    public DegreeProgram saveDetails(DegreeProgram degreeProgram){
        return degreeProgramRepo.save(degreeProgram);
    }
}
