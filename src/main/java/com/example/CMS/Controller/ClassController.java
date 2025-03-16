package com.example.CMS.Controller;

import com.example.CMS.DTO.ClassRequest;
import com.example.CMS.DTO.ClassResponse;
import com.example.CMS.Entity.Class;
import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Service.ClassService;
import com.example.CMS.Service.CourseService;
import com.example.CMS.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Class addClass(@RequestBody ClassRequest request) {
        Lecturer lecturer = lecturerService.getLecturerById(request.getLecturerID())
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));

        Course course = courseService.getCourseById(request.getCourseID())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Class Aclass = new Class();
        Aclass.setLecturer(lecturer);
        Aclass.setCourse(course);
        Aclass.setDay(request.getDay());
        Aclass.setStartTime(request.getStartTime());
        Aclass.setEndTime(request.getEndTime());
        Aclass.setStatus(request.getStatus());
        Aclass.setSemester(request.getSemester());
        Aclass.setYear(LocalDate.now().getYear());

        return classService.CreateClass(Aclass);
    }

    @GetMapping
    public List<ClassResponse> getAllClasses(){
        return classService.getAllClasses();
    }
}
