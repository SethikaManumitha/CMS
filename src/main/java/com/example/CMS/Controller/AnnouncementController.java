package com.example.CMS.Controller;

import com.example.CMS.DTO.AnnouncementDTO;
import com.example.CMS.Entity.Announcement;
import com.example.CMS.Service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@RequiredArgsConstructor
@CrossOrigin
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping("/add")
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody AnnouncementDTO dto) {
        return ResponseEntity.ok(announcementService.addAnnouncement(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Announcement>> getAllAnnouncement() {
        return ResponseEntity.ok(announcementService.getAllAnnouncements());
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Announcement>> getLatest10Announcement() {
        return ResponseEntity.ok(announcementService.getLatest10Announcements());
    }
}