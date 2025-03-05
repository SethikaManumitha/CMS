package com.example.CMS.Service;

import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.DegreeProgram;
import com.example.CMS.Repository.CourseRepo;
import com.example.CMS.Repository.DegreeProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling business logic related to Degree program entity.
 * Provides methods to interact with the Degree program repository.
 */
@Service
public class DegreeProgramService {
    @Autowired
    private DegreeProgramRepo degreeProgramRepo; // Injecting DegreeProgramRepo dependency

    @Autowired
    private CourseRepo courseRepo; // Added course repo to insert course to degree programme
    /**
     * Saves DegreeProgram details to the database.
     * @param degreeProgram department entity to be saved
     * @return Saved department entity
     */
    public DegreeProgram saveDetails(DegreeProgram degreeProgram){
        return degreeProgramRepo.save(degreeProgram);
    }

    public void deleteDegreeProgram(int id){
        degreeProgramRepo.deleteById(id);
    }

    public DegreeProgram assignCourses(int programId, List<Integer> courseIds) {
        DegreeProgram degreeProgram = degreeProgramRepo.findById(programId)
                .orElseThrow(() -> new RuntimeException("Degree Program not found"));

        List<Course> courses = courseRepo.findAllById(courseIds);
        degreeProgram.setCourses(courses);

        return degreeProgramRepo.save(degreeProgram);
    }
}
