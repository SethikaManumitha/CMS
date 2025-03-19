package com.example.CMS.Service;

import com.example.CMS.DTO.AnalyticsDTO;
import com.example.CMS.DTO.DegreeProgramStudentCountDTO;
import com.example.CMS.Entity.Course;
import com.example.CMS.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentAnalyticsService {

    private final StudentDegreeRepo studentDegreeRepository;

    private final StudentRepo studentRepository;
    private final LecturerRepo lecturerRepository;
    private final CourseRepo courseRepository;
    private final ResourceRepo classroomRepository;

    public List<DegreeProgramStudentCountDTO> getStudentCountsPerProgram() {
        return studentDegreeRepository.getStudentCountsByProgram();
    }

    public AnalyticsDTO getAnalytics() {
        int totalStudents = (int) studentRepository.count();
        int totalLecturers = (int) lecturerRepository.count();
        int totalCourses = (int) courseRepository.count();
        int totalClassrooms = (int) classroomRepository.count();

        return new AnalyticsDTO(totalStudents, totalLecturers, totalCourses, totalClassrooms);
    }

}
