package com.example.CMS.Repository;

import com.example.CMS.DTO.DegreeProgramStudentCountDTO;
import com.example.CMS.Entity.StudentDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDegreeRepo extends JpaRepository<StudentDegree, Integer> {
    @Query("SELECT new com.example.CMS.DTO.DegreeProgramStudentCountDTO(d.program_name, COUNT(sd)) " +
            "FROM StudentDegree sd " +
            "JOIN sd.degreeProgram d " +
            "GROUP BY d.program_name")
    List<DegreeProgramStudentCountDTO> getStudentCountsByProgram();
}
