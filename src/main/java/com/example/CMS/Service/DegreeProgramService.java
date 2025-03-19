package com.example.CMS.Service;

import com.example.CMS.DTO.CourseDTO;
import com.example.CMS.DTO.DegreeProgramDTO;
import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.DegreeProgram;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Repository.CourseRepo;
import com.example.CMS.Repository.DegreeProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<DegreeProgramDTO> getAllProgrammes() {
        List<DegreeProgram> degreePrograms = degreeProgramRepo.findAll();

        // Mapping the DegreeProgram entities to DegreeProgramDTO
        return degreePrograms.stream()
                .map(degreeProgram -> new DegreeProgramDTO(
                        degreeProgram.getProgramID(),
                        degreeProgram.getProgram_name(),
                        degreeProgram.getDescription(),
                        degreeProgram.getLevel(),
                        degreeProgram.getDegree_type(),
                        degreeProgram.getDuration(),
                        degreeProgram.getEntry_requirement(),
                        degreeProgram.getMax_students(),
                        degreeProgram.getStatus(),
                        degreeProgram.getCourses().stream()
                                .map(course -> new CourseDTO(course.getCourseID(), course.getCourseName(), course.getStatus())) // Mapping Course to CourseDTO
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }


    public List<DegreeProgramDTO> getAllDegreeProgramsWithCourses() {
        List<DegreeProgram> programs = degreeProgramRepo.findAll();

        return programs.stream().map(program -> new DegreeProgramDTO(
                program.getProgramID(),
                program.getProgram_name(),
                program.getDescription(),
                program.getLevel(),
                program.getDegree_type(),
                program.getDuration(),
                program.getEntry_requirement(),
                program.getMax_students(),
                program.getStatus(),
                program.getCourses().stream().map(course -> new CourseDTO(
                        course.getCourseID(),
                        course.getCourseName(),
                        course.getStatus()
                )).collect(Collectors.toList())
        )).collect(Collectors.toList());

    }
}
