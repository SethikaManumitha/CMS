package com.example.CMS.Service;

import com.example.CMS.Entity.Class;
import com.example.CMS.Entity.Timetable;
import com.example.CMS.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        timetable.setStartTime(newClass.getStartTime());
        timetable.setEndTime(newClass.getEndTime());
        timetable.setSemester(newClass.getSemester());
        timetable.setYear(newClass.getYear());
        timetable.setStatus("Active");

        timeTableRepo.save(timetable);
        return savedClass;
    }
}
