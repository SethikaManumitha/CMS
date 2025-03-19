package com.example.CMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.CMS.DTO.StudentCourseRequest;
import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.Student;
import com.example.CMS.Entity.StudentCourse;
import com.example.CMS.Repository.CourseRepo;
import com.example.CMS.Repository.StudentCourseRepo;
import com.example.CMS.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    @Autowired
    private StudentCourseRepo studentCourseRepository;

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private CourseRepo courseRepository;

    // Existing method to enroll student in a course
    public StudentCourse enrollStudentInCourse(StudentCourseRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudents(student);
        studentCourse.setCourse(course);
        studentCourse.setStatus(request.getStatus());
        studentCourse.setMarks(request.getMarks());

        return studentCourseRepository.save(studentCourse);
    }

    public List<StudentCourse> getStudentsByCourseId(int courseId) {
        return studentCourseRepository.findByCourseCourseID(courseId);
    }
}
