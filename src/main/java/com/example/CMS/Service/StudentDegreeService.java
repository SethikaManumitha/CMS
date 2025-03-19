package com.example.CMS.Service;

import com.example.CMS.DTO.StudentDegreeRequest;
import com.example.CMS.Entity.DegreeProgram;
import com.example.CMS.Entity.Student;
import com.example.CMS.Entity.StudentDegree;
import com.example.CMS.Repository.DegreeProgramRepo;
import com.example.CMS.Repository.StudentDegreeRepo;
import com.example.CMS.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentDegreeService {
    @Autowired
    private StudentDegreeRepo studentDegreeRepository;

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private DegreeProgramRepo degreeProgramRepository;

    public StudentDegree enrollStudentInDegree(StudentDegreeRequest request) {
        // Find student
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Find degree program
        DegreeProgram degreeProgram = degreeProgramRepository.findById(request.getProgramID())
                .orElseThrow(() -> new RuntimeException("Degree Program not found"));

        // Create new StudentDegree entry
        StudentDegree studentDegree = new StudentDegree();
        studentDegree.setStudent(student);
        studentDegree.setDegreeProgram(degreeProgram);
        studentDegree.setEnrollmentYear(request.getEnrollmentYear());
        studentDegree.setStatus(request.getStatus());
        studentDegree.setGrade(request.getGrade());

        // Save to database
        return studentDegreeRepository.save(studentDegree);
    }

    public List<Student> getStudentsEnrolledInDegree(int programId) {
        // Find the degree program
        DegreeProgram degreeProgram = degreeProgramRepository.findById(programId)
                .orElseThrow(() -> new RuntimeException("Degree Program not found"));

        // Retrieve all StudentDegree entries related to this degree program
        List<StudentDegree> studentDegrees = studentDegreeRepository.findByDegreeProgram(degreeProgram);

        // Extract students from the StudentDegree entries
        List<Student> students = studentDegrees.stream()
                .map(StudentDegree::getStudent)
                .collect(Collectors.toList());

        return students;
    }
}
