package com.example.CMS.Controller;

import com.example.CMS.DTO.DegreeProgramDTO;
import com.example.CMS.DTO.DepartmentLecturerDTO;
import com.example.CMS.DTO.DepartmentResourceDTO;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Service.DegreeProgramService;
import com.example.CMS.Service.DepartmentService;
import com.example.CMS.DTO.DegreeProgramStudentCountDTO;
import com.example.CMS.Entity.Department;
import com.example.CMS.Service.LecturerService;
import com.example.CMS.Service.StudentAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final StudentAnalyticsService studentAnalyticsService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private DegreeProgramService degreeProgramService;

    @GetMapping("/student-count-by-program")
    public ResponseEntity<List<DegreeProgramStudentCountDTO>> getStudentCountsByProgram() {
        return ResponseEntity.ok(studentAnalyticsService.getStudentCountsPerProgram());
    }

    @GetMapping("/department-resources")
    public ResponseEntity<List<DepartmentResourceDTO>> getAllDepartmentsWithResources() {
        List<DepartmentResourceDTO> departmentsWithResources = departmentService.getAllDepartmentsWithResources();
        return ResponseEntity.ok(departmentsWithResources);
    }

    @GetMapping("/department-lecturers")
    public Map<String, List<Lecturer>> getLecturersGroupedByDepartment() {
        return lecturerService.getLecturersGroupedByDepartment();
    }



    @GetMapping("/degrees-with-courses")
    public List<DegreeProgramDTO> getAllDegreeProgramsWithCourses() {
        return degreeProgramService.getAllDegreeProgramsWithCourses();
    }
}
