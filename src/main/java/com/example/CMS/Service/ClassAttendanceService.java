package com.example.CMS.Service;

import com.example.CMS.DTO.ClassAttendanceDTO;
import com.example.CMS.Entity.ClassAttendance;
import com.example.CMS.Entity.Class;
import com.example.CMS.Entity.User;
import com.example.CMS.Repository.ClassAttendanceRepository;
import com.example.CMS.Repository.ClassRepo;
import com.example.CMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassAttendanceService {

    @Autowired
    private ClassAttendanceRepository attendanceRepo;

    @Autowired
    private ClassRepo classRepo;

    @Autowired
    private UserRepo userRepo;

    public Boolean saveAttendance(ClassAttendanceDTO dto) {
        Class clazz = classRepo.findById(dto.getClassId())
                .orElseThrow(() -> new RuntimeException("Class not found"));

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ClassAttendance attendance = new ClassAttendance();
        attendance.setClazz(clazz);
        attendance.setUser(user);
        attendance.setStatus(dto.getStatus());
        try {
            attendanceRepo.save(attendance);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
