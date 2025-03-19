package com.example.CMS.Controller;

import com.example.CMS.DTO.ClassAttendanceDTO;
import com.example.CMS.Entity.ClassAttendance;
import com.example.CMS.Service.ClassAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class-attendance")
public class ClassAttendanceController {

    @Autowired
    private ClassAttendanceService attendanceService;

    @PostMapping("/mark")
    public Boolean markAttendance(@RequestBody ClassAttendanceDTO request) {
        return attendanceService.saveAttendance(request);
    }

}
