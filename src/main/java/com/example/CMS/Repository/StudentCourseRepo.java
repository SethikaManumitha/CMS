package com.example.CMS.Repository;

import com.example.CMS.Entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, Integer> {
}

