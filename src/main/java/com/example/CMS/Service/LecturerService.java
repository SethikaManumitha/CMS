package com.example.CMS.Service;

import com.example.CMS.DTO.DepartmentLecturerDTO;
import com.example.CMS.DTO.LecturerDTO;
import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Repository.LecturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepo lecturerRepository;

    public Lecturer saveLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    public Optional<Lecturer> getLecturerById(int id) {
        return lecturerRepository.findById(id);
    }

    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }


    public void deleteLecturer(int id){
        lecturerRepository.deleteById(id);
    }


    public Map<String, List<Lecturer>> getLecturersGroupedByDepartment() {
        List<Lecturer> lecturers = lecturerRepository.findAll();

        // Group lecturers by department name (String)
        return lecturers.stream()
                .filter(l -> l.getDepartment() != null && l.getDepartment().getDeptName() != null)
                .collect(Collectors.groupingBy(l -> l.getDepartment().getDeptName()));
    }

}
