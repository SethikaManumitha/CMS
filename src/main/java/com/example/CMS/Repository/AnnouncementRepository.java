package com.example.CMS.Repository;

import com.example.CMS.Entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

    @Query(value = "SELECT a FROM Announcement a ORDER BY a.announcementId DESC LIMIT 10")
    List<Announcement> findTop10ByOrderByAnnouncementIdDesc();
}