package com.example.CMS.Service;

import com.example.CMS.DTO.NotificationDTO;
import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Notification;
import com.example.CMS.Repository.AdminRepo;
import com.example.CMS.Repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final AdminRepo adminRepository;

    public Notification addNotification(NotificationDTO dto) {
        Admin admin = adminRepository.findById(dto.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        Notification notification = new Notification();
        notification.setNotification(dto.getNotification());
        notification.setDate(dto.getDate());
        notification.setTime(dto.getTime());
        notification.setUserType(dto.getUserType());
        notification.setAdmin(admin);

        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsFor(String userType) {
        return notificationRepository.findByUserTypeIn(Arrays.asList(userType, "all"));
    }

    public List<Notification> getLatest10NotificationsFor(String userType) {
        return notificationRepository.findLatest10ByUserType(userType);
    }

    public List<Notification> getNotificationsByDateAndUserType(String date, String userType) {
        return notificationRepository.findByDateAndUserType(date, userType);
    }

}
