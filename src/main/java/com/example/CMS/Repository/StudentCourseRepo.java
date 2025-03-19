package com.example.CMS.Repository;

import com.example.CMS.Entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, Integer> {

    List<StudentCourse> findByCourseCourseID(int courseId);

}

