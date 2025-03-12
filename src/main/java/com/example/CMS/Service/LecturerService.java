package com.example.CMS.Service;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Repository.LecturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
