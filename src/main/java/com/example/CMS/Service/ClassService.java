package com.example.CMS.Service;

import com.example.CMS.DTO.ClassRequest;
import com.example.CMS.Entity.Class;
import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Entity.Admin;
import com.example.CMS.Repository.AdminRepo;
import com.example.CMS.Repository.ClassRepo;
import com.example.CMS.Repository.CourseRepo;
import com.example.CMS.Repository.LecturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    private ClassRepo classRepository;

    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private LecturerRepo lecturerRepository;

    @Autowired
    private AdminRepo adminRepository;

    public Class CreateClass(ClassRequest request) {
        Course course = courseRepository.findById(request.getCourseID())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Lecturer lecturer = lecturerRepository.findById(request.getLecturerID())
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));
        Admin admin = adminRepository.findById(request.getAdminID())
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));

        Class newClass = new Class();
        newClass.setCourse(course);
        newClass.setLecturer(lecturer);
        newClass.setAdmin(admin);

        return classRepository.save(newClass);
    }
}
