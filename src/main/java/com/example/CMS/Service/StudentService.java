package com.example.CMS.Service;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Student;
import com.example.CMS.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo StudentRepository;

    public Student saveStudent(Student Student) {
        return StudentRepository.save(Student);
    }

    public Optional<Student> getStudentById(int id) {
        return StudentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return StudentRepository.findAll();
    }


    public void deleteStudent(int id){
        StudentRepository.deleteById(id);
    }
}
