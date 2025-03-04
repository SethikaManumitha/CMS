package com.example.CMS.Repository;

import com.example.CMS.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for course entity.
 * Extends JpaRepository to provide CRUD operations on the course table.
 */
@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
}
