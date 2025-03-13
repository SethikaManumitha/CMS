package com.example.CMS.Service;

import com.example.CMS.DTO.AnnouncementDTO;
import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Announcement;
import com.example.CMS.Repository.AdminRepo;
import com.example.CMS.Repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AdminRepo adminRepository;

    public Announcement addAnnouncement(AnnouncementDTO dto) {
        Admin admin = adminRepository.findById(dto.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        Announcement announcement = new Announcement();
        announcement.setDate(dto.getDate());
        announcement.setClosingDate(dto.getClosingDate());
        announcement.setMessage(dto.getMessage());
        announcement.setAdmin(admin);

        return announcementRepository.save(announcement);
    }

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public List<Announcement> getLatest10Announcements() {
        return announcementRepository.findTop10ByOrderByAnnouncementIdDesc();
    }
}