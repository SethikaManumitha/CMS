package com.example.CMS.Service;

import com.example.CMS.DTO.DegreeProgramStudentCountDTO;
import com.example.CMS.Repository.StudentDegreeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentAnalyticsService {

    private final StudentDegreeRepo studentDegreeRepository;

    public List<DegreeProgramStudentCountDTO> getStudentCountsPerProgram() {
        return studentDegreeRepository.getStudentCountsByProgram();
    }
}
