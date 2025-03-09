package com.example.CMS.Service;

import com.example.CMS.Entity.Class;
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

    public Class CreateClass(Class newClass) {
        return classRepository.save(newClass);
    }
}
