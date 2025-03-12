package com.example.CMS.Controller;

import com.example.CMS.DTO.EventAttendanceDTO;
import com.example.CMS.Entity.EventAttendance;
import com.example.CMS.Service.EventAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event-attendance")
@CrossOrigin("*")
public class EventAttendanceController {

    @Autowired
    private EventAttendanceService attendanceService;

    @PostMapping("/mark")
    public EventAttendance markAttendance(@RequestBody EventAttendanceDTO dto) {
        return attendanceService.saveAttendance(dto);
    }
}
