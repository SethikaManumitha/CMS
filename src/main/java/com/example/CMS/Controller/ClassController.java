package com.example.CMS.Controller;


import com.example.CMS.DTO.ClassRequest;
import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Class;
import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Service.AdminService;
import com.example.CMS.Service.ClassService;
import com.example.CMS.Service.CourseService;
import com.example.CMS.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private CourseService courseService;


    @Autowired
    private AdminService adminService;


    @PostMapping
    public Class addClass(@RequestBody Class request) {
        Lecturer lecturer =  lecturerService.getLecturerById(request.getLecturer().getLecturerID())
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));

        Course course =  courseService.getCourseById(request.getCourse().getCourseID())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Admin admin =  adminService.getAdminById(request.getAdmin().getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        Class Aclass = new Class();

        Aclass.setLecturer(lecturer);
        Aclass.setCourse(course);
        Aclass.setAdmin(admin);
        Aclass.setDay(request.getDay());
        Aclass.setStartTime(request.getStartTime());
        Aclass.setEndTime(request.getEndTime());
        Aclass.setMaxStudents(request.getMaxStudents());
        Aclass.setStatus(request.getStatus());


        return classService.CreateClass(Aclass);
    }
}