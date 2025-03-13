package com.example.CMS.Controller;

import com.example.CMS.DTO.NotificationDTO;
import com.example.CMS.Entity.Notification;
import com.example.CMS.Service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@CrossOrigin
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/add")
    public ResponseEntity<Notification> addNotification(@RequestBody NotificationDTO dto) {
        return ResponseEntity.ok(notificationService.addNotification(dto));
    }

    @GetMapping("/students")
    public ResponseEntity<List<Notification>> getForStudents() {
        return ResponseEntity.ok(notificationService.getNotificationsFor("student"));
    }

    @GetMapping("/lecturers")
    public ResponseEntity<List<Notification>> getForLecturers() {
        return ResponseEntity.ok(notificationService.getNotificationsFor("lecturer"));
    }

    @GetMapping("/admins")
    public ResponseEntity<List<Notification>> getForAdmins() {
        return ResponseEntity.ok(notificationService.getNotificationsFor("admin"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Notification>> getForEveryone() {
        return ResponseEntity.ok(notificationService.getNotificationsFor("all"));
    }

    @GetMapping("/{userType}/latest")
    public ResponseEntity<List<Notification>> getLatest10(@PathVariable String userType) {
        return ResponseEntity.ok(notificationService.getLatest10NotificationsFor(userType));
    }

    @GetMapping("/{userType}/by-date")
    public ResponseEntity<List<Notification>> getByDate(
            @PathVariable String userType,
            @RequestParam String date
    ) {
        return ResponseEntity.ok(notificationService.getNotificationsByDateAndUserType(date, userType));
    }

}
