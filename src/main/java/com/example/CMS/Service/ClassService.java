package com.example.CMS.Service;

import com.example.CMS.DTO.ClassResponse;
import com.example.CMS.Entity.Class;
import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.Timetable;
import com.example.CMS.Repository.ClassRepo;
import com.example.CMS.Repository.TimeTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassService {
    @Autowired
    private ClassRepo classRepository;

    @Autowired
    private TimeTableRepo timeTableRepo;

    public Class CreateClass(Class newClass) {
        Class savedClass = classRepository.save(newClass);

        Timetable timetable = new Timetable();
        timetable.setClassEntity(savedClass);
        timetable.setDayOfWeek(newClass.getDay());
        timetable.setStartTime(newClass.getStartTime().toString());
        timetable.setEndTime(newClass.getEndTime().toString());
        timetable.setSemester(newClass.getSemester());
        timetable.setYear(newClass.getYear());
        timetable.setStatus("Active");

        timeTableRepo.save(timetable);
        return savedClass;
    }

    public Optional<Class> getClassById(int id) {
        return classRepository.findById(id);
    }

    public List<ClassResponse> getAllClasses() {
        List<Class> classes = classRepository.findAll();

        return classes.stream().map(clazz ->
                new ClassResponse(
                        clazz.getClassID(),
                        clazz.getCourse().getCourseID(),
                        clazz.getCourse().getCourseName(),
                        clazz.getLecturer().getLecturerID(),
                        clazz.getLecturer().getUser().getFirstName() + " " + clazz.getLecturer().getUser().getLastName(),
                        clazz.getDay(),
                        clazz.getStartTime().toString(),
                        clazz.getEndTime().toString()
                )
        ).collect(Collectors.toList());
    }
}
