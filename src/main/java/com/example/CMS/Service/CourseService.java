package com.example.CMS.Service;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Course;
import com.example.CMS.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for handling business logic related to course entity.
 * Provides methods to interact with the course repository.
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo; // Injecting course dependency

    /**
     * Saves course details to the database.
     * @param course course entity to be saved
     * @return Saved course entity
     */
    public Course saveDetails(Course course){
        return courseRepo.save(course);
    }
    public Optional<Course> getCourseById(int id) {
        return courseRepo.findById(id);
    }

    public void deleteCourse(int id){
        courseRepo.deleteById(id);}
}
