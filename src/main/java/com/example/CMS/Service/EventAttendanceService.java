package com.example.CMS.Service;

import com.example.CMS.DTO.EventAttendanceDTO;
import com.example.CMS.Entity.EventAttendance;
import com.example.CMS.Entity.Event;
import com.example.CMS.Entity.User;
import com.example.CMS.Repository.EventAttendanceRepository;
import com.example.CMS.Repository.EventRepo;
import com.example.CMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventAttendanceService {

    @Autowired
    private EventAttendanceRepository attendanceRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepo userRepo;

    public EventAttendance saveAttendance(EventAttendanceDTO dto) {
        Event event = eventRepo.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        EventAttendance attendance = new EventAttendance();
        attendance.setEvent(event);
        attendance.setUser(user);
        attendance.setDate(dto.getDate());
        attendance.setTime(dto.getTime());

        return attendanceRepo.save(attendance);
    }
}
