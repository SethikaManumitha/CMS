package com.example.CMS.Repository;

import com.example.CMS.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for course entity.
 * Extends JpaRepository to provide CRUD operations on the course table.
 */
public interface CourseRepo extends JpaRepository<Course, Integer> {
}
