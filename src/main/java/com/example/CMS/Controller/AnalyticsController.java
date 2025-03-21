package com.example.CMS.Controller;

import com.example.CMS.DTO.*;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Entity.Resource;
import com.example.CMS.Service.*;
import com.example.CMS.Entity.Department;
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

    @Autowired
    private ResourceService resourceService;


    @GetMapping("/capacity-count")
    public ResponseEntity<Map<String, Integer>> getResourcesByCapacityCount() {
        Map<String, Integer> capacityCount = resourceService.getResourcesByCapacityCount();
        return ResponseEntity.ok(capacityCount);
    }

    @GetMapping("/summary")
    public ResponseEntity<AnalyticsDTO> getAnalyticsSummary() {
        return ResponseEntity.ok(studentAnalyticsService.getAnalytics());
    }

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
