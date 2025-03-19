package com.example.CMS.Service;

import com.example.CMS.DTO.CourseDTO;
import com.example.CMS.DTO.DegreeProgramDTO;
import com.example.CMS.DTO.StudentResponseDTO;
import com.example.CMS.Entity.Student;
import com.example.CMS.Entity.StudentCourse;
import com.example.CMS.Entity.StudentDegree;
import com.example.CMS.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    // Mapping method for DegreeProgramDTO
    private DegreeProgramDTO mapToDegreeProgramDTO(StudentDegree studentDegree) {
        return new DegreeProgramDTO(
                studentDegree.getDegreeProgram().getProgramID(),
                studentDegree.getDegreeProgram().getProgram_name(),
                studentDegree.getDegreeProgram().getDescription(),
                studentDegree.getDegreeProgram().getLevel(),
                studentDegree.getDegreeProgram().getDegree_type(),
                studentDegree.getDegreeProgram().getDuration(),
                studentDegree.getDegreeProgram().getEntry_requirement(),
                studentDegree.getDegreeProgram().getMax_students(),
                studentDegree.getDegreeProgram().getStatus(),
                null
        );
    }

    // Mapping method for CourseDTO
    private CourseDTO mapToCourseDTO(StudentCourse studentCourse) {
        return new CourseDTO(
                studentCourse.getCourse().getCourseID(),
                studentCourse.getCourse().getCourseName(),
                studentCourse.getCourse().getStatus()
        );
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentByUserID(int userID) {
        return studentRepository.findByUser_Id(userID);
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Optional<StudentResponseDTO> getStudentByIDResponse(int id) {
        return studentRepository.findById(id).map(student ->
                new StudentResponseDTO(
                        student.getStudentID(),
                        student.getUser().getFirstName(),
                        student.getUser().getLastName(),
                        student.getUser().getEmail(),
                        student.getStudentDegrees().stream()
                                .map(this::mapToDegreeProgramDTO) // Mapping StudentDegree to DegreeProgramDTO
                                .collect(Collectors.toList()),
                        student.getStudentCourses().stream()
                                .map(this::mapToCourseDTO) // Mapping StudentCourse to CourseDTO
                                .collect(Collectors.toList())
                )
        );
    }

    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> new StudentResponseDTO(
                        student.getStudentID(),
                        student.getUser().getFirstName(),
                        student.getUser().getLastName(),
                        student.getUser().getEmail(),
                        student.getStudentDegrees().stream()
                                .map(this::mapToDegreeProgramDTO) // Mapping StudentDegree to DegreeProgramDTO
                                .collect(Collectors.toList()),
                        student.getStudentCourses().stream()
                                .map(this::mapToCourseDTO) // Mapping StudentCourse to CourseDTO
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
