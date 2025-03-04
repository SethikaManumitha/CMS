package com.example.CMS.Repository;

import com.example.CMS.Entity.DegreeProgramCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for degree Program course entity.
 * Extends JpaRepository to provide CRUD operations on the degree Program course table.
 */
public interface DegreeProgramCourseRepo extends JpaRepository<DegreeProgramCourse, Integer> {
}
